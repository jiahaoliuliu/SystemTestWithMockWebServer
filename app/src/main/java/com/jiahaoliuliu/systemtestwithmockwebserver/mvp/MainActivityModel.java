package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

import android.util.Log;

import com.jiahaoliuliu.systemtestwithmockwebserver.repository.RandomOrg;
import com.jiahaoliuliu.systemtestwithmockwebserver.repository.request.RequestModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class MainActivityModel implements MainActivityContract.Model {

    private static final String TAG = "MainActivityModel";

    private static final int NUMBER_OF_DATA_RETURNED = 1;
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 1000;

    private RandomOrg mRandomOrg;
    private RequestModel mRequestModel;

    public MainActivityModel() {
        this.mRandomOrg = new RandomOrg();
        mRequestModel = new RequestModel(
                NUMBER_OF_DATA_RETURNED, MINIMUM_VALUE, MAXIMUM_VALUE);
    }

    // TODO: Request the data to the repository
    @Override
    public void generateNewNumber(final MainActivityContract.NumberGenerationCallback numberGenerationCallback) {
        Log.v(TAG, "Request model " + mRequestModel);
        mRandomOrg.getRandomOrgService().getRandomNumber(mRequestModel).enqueue(new Callback<RequestModel>() {
            @Override
            public void onResponse(Call<RequestModel> call, Response<RequestModel> response) {
                if(response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                    numberGenerationCallback.onSuccess(42);
                }
            }

            @Override
            public void onFailure(Call<RequestModel> call, Throwable t) {
                numberGenerationCallback.onFailure();
            }
        });
    }
}
