package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.tal.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Tal on 9/26/2016.
 */

class EndpointsAsyncTask extends AsyncTask<CountDownLatch, Void, String> {
    private final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    CountDownLatch latch;
    private String joke;


    @Override
    protected String doInBackground(CountDownLatch... params) {
        Log.i(LOG_TAG, "Asynctask called");
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-144704.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        latch = params[0];
        Log.i(LOG_TAG, latch.toString());

        try {
            joke = myApiService.getJoke().execute().getData();
            Log.i(LOG_TAG, joke);
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        joke = result;

        Log.i(LOG_TAG, joke);
        latch.countDown();
        Log.i(LOG_TAG, "onPostExecute complete");
        Log.i(LOG_TAG, latch.toString());

    }

    public String getJoke(){
        return joke;
    }
}
