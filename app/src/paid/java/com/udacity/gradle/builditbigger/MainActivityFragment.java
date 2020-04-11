package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;

import java.io.IOException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();
    private Context mContext;
    private static FragmentMainBinding mDataBinding;
    private static receivedDataListener mReceivedData;
    private static String mData;
    @Nullable
    private static SimpleIdlingResource mIdlingResource;


    interface receivedDataListener {
        void receivedJokeData(String joke);
    }

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDataBinding = FragmentMainBinding.inflate(inflater, container, false);
        View root = mDataBinding.getRoot();
        mContext = this.getContext();

        mIdlingResource = MainActivity.getmIdlingResource();

        mDataBinding.buttonTellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BackEndAsyncTask().execute(mContext);
            }
        });

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mReceivedData = (receivedDataListener) context;
        }catch (ClassCastException ex){
            throw new ClassCastException(" Listeners not implemented");
        }
    }



    static class BackEndAsyncTask extends AsyncTask<Context, Void, String> {

        private static MyApi myApiService = null;
        private Context context;

        @Override
        protected void onPreExecute() {
           mDataBinding.pbJoke.setVisibility(View.VISIBLE);
           mDataBinding.tvErrorMsg.setVisibility(View.INVISIBLE);
            if(mIdlingResource != null){
                mIdlingResource.setIdleState(false);
            }
        }

        @Override
        protected String doInBackground(Context... contexts) {
            if(myApiService == null){

                MyApi.Builder apiBuilder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(),
                        null)
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                                request.setDisableGZipContent(true);
                            }
                        });
                myApiService = apiBuilder.build();
            }
            context = contexts[0];

            try {
                return myApiService.sayJoke().execute().getData();
            } catch (IOException e) {
                return null;
            }
        }


        @Override
        protected void onPostExecute(String s) {
            if(mIdlingResource != null){
                mIdlingResource.setIdleState(true);
            }
            if (s == null) {
                showErrorMsg();
            } else {
                mData = s;
                mDataBinding.pbJoke.setVisibility(View.INVISIBLE);
                mReceivedData.receivedJokeData(s);
            }
        }
    }

    private static void showErrorMsg()
    {
        mDataBinding.buttonTellJoke.setEnabled(false);
        mDataBinding.tvErrorMsg.setVisibility(View.VISIBLE);
        mDataBinding.pbJoke.setVisibility(View.INVISIBLE);
    }

}
