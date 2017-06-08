package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

import android.util.Log;

import com.jiahaoliuliu.systemtestwithmockwebserver.repository.RandomOrg;
import com.jiahaoliuliu.systemtestwithmockwebserver.repository.request.RequestModel;
import com.jiahaoliuliu.systemtestwithmockwebserver.repository.response.ResponseModel;

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

    @Override
    public void generateNewNumber(final MainActivityContract.NumberGenerationCallback numberGenerationCallback) {
        Log.v(TAG, "Request model " + mRequestModel);

        mRandomOrg.getRandomOrgService().getRandomNumber(mRequestModel).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                    ResponseModel responseModel = response.body();
                    numberGenerationCallback.onSuccess(responseModel.getResult().getRandom().getData()[0]);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.i(TAG, "Failed to request random number to the backend.");
                numberGenerationCallback.onFailure();
            }
        });
    }
}
