package com.gradle.udacity.testing;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.extensions.TestSetup;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by GOURAV on 13-11-2016.
 */


public class AndroidTest extends InstrumentationTestCase{

    private static boolean called;
    private static String value;

    protected void setUp() throws Exception {
        super.setUp();
        called = false;
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSuccessfulFetch() throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        // Execute the async task on the UI thread! THIS IS KEY!
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new EndpointsAsyncTask() {
                    @Override
                    protected void onPostExecute(String response) {
//                        Log.d(TAG, "running onPostExecute");
                        super.onPostExecute(response);

	    	            /* This is the key, normally you would use some type of listener
	    	             * to notify your activity that the async call was finished.
	    	             *
	    	             * In your test method you would subscribe to that and signal
	    	             * from there instead.
	    	             */
                        called = true;
                        value = response;
                        signal.countDown();
                    }
                }.execute();
            }
        });

	    /* The testing thread will wait here until the UI thread releases it
	     * above with the countDown() or 30 seconds passes and it times out.
	     */
//        signal.await(30, TimeUnit.SECONDS);
        assertTrue(called);
        assertNotNull(value);
        assertEquals(value.length() > 0,true);
    }
}