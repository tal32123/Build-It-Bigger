package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.tal.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tal on 9/27/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    String joke;

    @Before
    public void preTest() throws Exception {

        EndpointsAsyncTask endpointsAsyncTask
                = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();
    }



    @RunWith(AndroidJUnit4.class)
    @LargeTest
    class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
        private Context context;
        private MyApi myApiService = null;


        @Override
        protected String doInBackground(Void... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://build-it-bigger-144704.appspot.com/_ah/api/");
                // end options for devappserver

                myApiService = builder.build();
            }


            try {
                return myApiService.getJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            joke = result;
            testShouldPassTheseAsserts();
            testShouldFailTheseAsserts();

        }

    }
    @Test
    public void testShouldPassTheseAsserts(){
        assert(joke != null);

        assertNotNull(joke);
    }
    @Test
    public void testShouldFailTheseAsserts(){
        assertTrue(joke.equals("Hello"));
        assertEquals(joke, null);
    }

}