package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import tk.talcharnes.joketivity.Joketivity;


public class MainActivity extends ActionBarActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    EndpointsAsyncTask endpointsAsyncTask;
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



    public void tellJoke(View view) {

        endpointsAsyncTask = new EndpointsAsyncTask(){
            @Override
            protected Void doInBackground(Object... params) {
                super.doInBackground(params);
                String joke = endpointsAsyncTask.getJoke();
                Intent jokeIntent = new Intent(getApplicationContext(), Joketivity.class);
                jokeIntent.putExtra(Joketivity.INTENT_JOKE_TAG, joke);
                startActivity(jokeIntent);
                return null;
            }
        };
        endpointsAsyncTask.execute();
    }

    }



