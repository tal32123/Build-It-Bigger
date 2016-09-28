package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

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
    }


    @Test
    public void testShouldPassTheseAsserts(){
        setUpTest();
        assert(joke != null);

        assertNotNull(joke);
    }


    @Test
    public void testTest(){
        assertEquals("Test Passed", "Test Passed");
    }

}