package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.IdlingResource;

import com.example.displayjoke.DisplayActivity;



public class MainActivity extends AppCompatActivity implements MainActivityFragment.receivedDataListener{

    public static final String TAG = MainActivity.class.getSimpleName();
    @Nullable private static SimpleIdlingResource mIdlingResource;

    @Nullable
    public static SimpleIdlingResource getmIdlingResource() {
        return mIdlingResource;
    }

    @VisibleForTesting
    @NonNull
    public  IdlingResource getIdlingResource(){
        if(mIdlingResource == null){
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void receivedJokeData(String joke) {
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(DisplayActivity.BUNDLE_EXTRA_JOKE, joke);
        startActivity(intent);
    }
}
