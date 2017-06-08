package com.jiahaoliuliu.systemtestwithmockwebserver;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jiahaoliuliu.systemtestwithmockwebserver.mvp.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by jiahaoliu on 6/8/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final Integer SERVER_PORT = 4444;

    private MockWebServer mMockWebServer;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mMockWebServer = new MockWebServer();
        mMockWebServer.start(SERVER_PORT);
    }

    @After
    public void tearDown() throws Exception {
        if (mMockWebServer != null) {
            mMockWebServer.shutdown();
        }
    }

    @Test
    public void testInitialValue() {
        onView(withId(R.id.number_tv))
                .check(matches(isDisplayed()))
                .check(matches(withText("0")));
    }

    @Test
    public void testRequestingNewNumber() throws Exception{
        onView(withId(R.id.number_tv))
                .check(matches(isDisplayed()))
                .perform(click());

        // Wait for the response
        Thread.sleep(5*1000);

        onView(withId(R.id.number_tv))
                .check(matches(not(withText("0"))));
    }

}
