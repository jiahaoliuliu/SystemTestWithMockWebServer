package com.jiahaoliuliu.systemtestwithmockwebserver.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class RandomOrg {

    private RandomOrgService mRandomOrgService;

    // Two different endpoints. One for production and one for functional test
    private static final String PROD_END_POINT = "https://api.random.org";
    private static final String QA_END_POINT = "http://localhost:4444";


    public RandomOrg() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(QA_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRandomOrgService = retrofit.create(RandomOrgService.class);
    }

    public RandomOrgService getRandomOrgService() {
        return mRandomOrgService;
    }

}
