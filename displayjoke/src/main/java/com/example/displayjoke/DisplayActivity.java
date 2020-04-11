package com.example.displayjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;



public class DisplayActivity extends AppCompatActivity {

    public static final String BUNDLE_EXTRA_JOKE = "bundle_extra_joke";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(BUNDLE_EXTRA_JOKE);
        TextView jokeView = (TextView) findViewById(R.id.tv_joke_display);
        jokeView.setText(joke);

    }
}
