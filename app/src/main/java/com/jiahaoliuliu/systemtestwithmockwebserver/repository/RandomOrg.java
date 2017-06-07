package com.jiahaoliuliu.systemtestwithmockwebserver.repository;

import retrofit2.Retrofit;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class RandomOrg {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.random.org/")
            .build();

    RandomOrgService service = retrofit.create(RandomOrgService.class);
}
