package com.ts.robolectricdemo;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void clickingLogin_shouldStartLoginActivity() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup(); // Moves the Activity to the RESUMED state

            MainActivity activity = controller.get();
            activity.findViewById(R.id.text_hw).performClick();
            assertEquals(((TextView) activity.findViewById(R.id.text_hw)).getText(), "Hello World!");
        }
    }

    @Test
    public void testGetActionBar(){
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup(); // Moves the Activity to the RESUMED state

            MainActivity activity = controller.get();

            assertNull(activity.get());
        }
    }
}