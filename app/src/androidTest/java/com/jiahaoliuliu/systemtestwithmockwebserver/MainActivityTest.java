package com.jiahaoliuliu.systemtestwithmockwebserver;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.jiahaoliuliu.systemtestwithmockwebserver.mvp.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

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

    private static final String TAG = "MainActivityTest";

    private static final Integer SERVER_PORT = 4444;

    private MockWebServer mMockWebServer;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mMockWebServer = new MockWebServer();

        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                if (request.getPath().equals("/json-rpc/1/invoke")) {
                    return new MockResponse().setResponseCode(200).setBody("{\n" +
                            "  \"jsonrpc\": \"2.0\",\n" +
                            "  \"result\": {\n" +
                            "    \"random\": {\n" +
                            "      \"data\": [\n" +
                            "        863\n" +
                            "      ],\n" +
                            "      \"completionTime\": \"2017-06-08 13:01:39Z\"\n" +
                            "    },\n" +
                            "    \"bitsUsed\": 10,\n" +
                            "    \"bitsLeft\": 249930,\n" +
                            "    \"requestsLeft\": 993,\n" +
                            "    \"advisoryDelay\": 80\n" +
                            "  },\n" +
                            "  \"id\": 42\n" +
                            "}");
                }
                return new MockResponse().setResponseCode(404);
            }
        };
        mMockWebServer.setDispatcher(dispatcher);
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

        // Getting request from the server
        RecordedRequest request1 = mMockWebServer.takeRequest();
        Log.d(TAG, "The first request is " + request1 + ", Path: " + request1.getPath() +
                ", header: " + request1.getHeaders() + ", Body: " + request1.getBody().readUtf8());

        HttpUrl httpUrl = mMockWebServer.url("");

        Log.d(TAG, "The base http url is " + httpUrl.toString());

        onView(withId(R.id.number_tv))
                .check(matches(not(withText("0"))));
    }

}
