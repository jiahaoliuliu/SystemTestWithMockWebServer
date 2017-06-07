package com.jiahaoliuliu.systemtestwithmockwebserver.repository;

import com.jiahaoliuliu.systemtestwithmockwebserver.repository.request.RequestModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jiahaoliu on 6/7/17.
 */

public interface RandomOrgService {

    @POST("json-rpc/1/invoke")
    Call<RequestModel> createUser(@Body RequestModel requestModel);
}
