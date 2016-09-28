package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Tal on 9/27/2016.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    private final String LOG_TAG = EndpointsAsyncTaskTest.class.getSimpleName();
 String joke;
private CountDownLatch latch;
    @Before
    public void setUpTest(){
        latch = new CountDownLatch(1);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(latch);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        joke = endpointsAsyncTask.getJoke();
        Log.d(LOG_TAG, joke);
    }


    @Test
    public void testShouldPassTheseAsserts(){
        setUpTest();
        assert(joke != null);

        assertNotNull(joke);
    }

/*
    Uncomment the following code in order to purposely fail the tests to ensure that code is working
 */
//    @Test
//    public void testShouldFailTheseAsserts(){
//        setUpTest();
//        assert(joke == null);
//
//        assertEquals(joke, "This is not funny!");
//    }


    @Test
    public void testTest(){
        assertEquals("Test Passed", "Test Passed");
    }

}