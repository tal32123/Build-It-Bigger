package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.JokeifyMe;

import java.util.concurrent.CountDownLatch;

import tk.talcharnes.joketivity.Joketivity;


public class MainActivity extends ActionBarActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
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


    JokeifyMe jokeifyMe = new JokeifyMe();

    public void tellJoke(View view) {
        Toast.makeText(this, R.string.fetching_joke, Toast.LENGTH_SHORT);
        CountDownLatch latch = new CountDownLatch(1);

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(latch);
        try {
            Log.i(LOG_TAG, "latch awaiting");
            latch.await();
            Log.i(LOG_TAG, "await called");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String joke = endpointsAsyncTask.getJoke();
        Log.i(LOG_TAG, joke);
        Intent jokeIntent = new Intent(getApplicationContext(), Joketivity.class);
        jokeIntent.putExtra(Joketivity.INTENT_JOKE_TAG, joke);
        startActivity(jokeIntent);
    }


}
