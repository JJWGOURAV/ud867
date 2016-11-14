package com.example.jokeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        TextView jokeText = (TextView) findViewById(R.id.jokeContent);

        Intent intent = getIntent();

        String joke = intent.getStringExtra("joke");

        jokeText.setText(joke);
    }
}
