package com.jiahaoliuliu.systemtestwithmockwebserver;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.google.gson.Gson;
import com.jiahaoliuliu.systemtestwithmockwebserver.mvp.MainActivity;
import com.jiahaoliuliu.systemtestwithmockwebserver.repository.RandomOrgService;
import com.jiahaoliuliu.systemtestwithmockwebserver.repository.request.RequestModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.not;

/**
 * Created by jiahaoliu on 6/8/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String TAG = "MainActivityTest";

    private static final Integer SERVER_PORT = 4444;

    private MockWebServer mMockWebServer;

    private Map<String, RecordedRequest> mRecordedRequestMap;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mMockWebServer = new MockWebServer();

        mRecordedRequestMap = new HashMap<>();

        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

                mRecordedRequestMap.put(request.getPath(), request);

                if (request.getPath().equals(RandomOrgService.REQUEST_RANDOM_NUMBER_URL)) {
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

    /**
     * Testing the interface, along with the backend calls. In this case we use MockWebServer to
     * mock the backend response, as well as to capture the requests and check if they are correct.
     *
     * TODO: In order to make it work, change the variable at {@link com.jiahaoliuliu.systemtestwithmockwebserver.repository.RandomOrg
     * from PROD_END_POINT to QA_END_POINT}
     *
     * @throws Exception
     */
    @Test
    public void testRequestingNewNumber() throws Exception{
        onView(withId(R.id.number_tv))
                .check(matches(isDisplayed()))
                .perform(click());

        // Getting request from the server
        RecordedRequest request = mMockWebServer.takeRequest();

        // Check the path
        assertEquals(RandomOrgService.REQUEST_RANDOM_NUMBER_URL, request.getPath());

        // Check the header
        assertEquals("application/json; charset=UTF-8", request.getHeader("Content-Type"));

        // Check the body
        String bodyString = request.getBody().readUtf8();

        Gson gson = new Gson();
        RequestModel requestModel = gson.fromJson(bodyString, RequestModel.class);

        assertEquals(requestModel.getParams().getMin(), 1);
        assertEquals(requestModel.getParams().getMax(), 1000);
        assertEquals(requestModel.getParams().getN(), 1);

        // Wait for the backend response
        Thread.sleep(2*1000);

        onView(withId(R.id.number_tv))
                .check(matches(not(withText("0"))));
    }

}
