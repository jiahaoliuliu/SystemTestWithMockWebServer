package com.jiahaoliuliu.systemtestwithmockwebserver.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class RandomOrg {

    private RandomOrgService mRandomOrgService;

    public RandomOrg() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.random.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRandomOrgService = retrofit.create(RandomOrgService.class);
    }

    public RandomOrgService getRandomOrgService() {
        return mRandomOrgService;
    }

}
