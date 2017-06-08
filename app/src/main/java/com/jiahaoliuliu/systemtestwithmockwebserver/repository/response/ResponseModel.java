package com.jiahaoliuliu.systemtestwithmockwebserver.repository.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiahaoliu on 6/8/17.
 * {
 *  "jsonrpc": "2.0",
 *  "result": {
 *  "random": {
 *  "data": [
 *      863
 *      ],
 *  "completionTime": "2017-06-08 13:01:39Z"
 *  },
 *  "bitsUsed": 10,
 *  "bitsLeft": 249930,
 *  "requestsLeft": 993,
 *  "advisoryDelay": 80
 *  },
 *  "id": 42
 * }
 */
public class ResponseModel {

    private int id;
    @SerializedName("jsonrpc")
    private String jsonRpc;
    private Result result;

    public ResponseModel() {
    }

    public ResponseModel(int id, String jsonRpc, Result result) {
        this.id = id;
        this.jsonRpc = jsonRpc;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJsonRpc() {
        return jsonRpc;
    }

    public void setJsonRpc(String jsonRpc) {
        this.jsonRpc = jsonRpc;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseModel that = (ResponseModel) o;

        if (id != that.id) return false;
        if (jsonRpc != null ? !jsonRpc.equals(that.jsonRpc) : that.jsonRpc != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;

    }

    @Override
    public int hashCode() {
        int result1 = id;
        result1 = 31 * result1 + (jsonRpc != null ? jsonRpc.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "id=" + id +
                ", jsonRpc='" + jsonRpc + '\'' +
                ", result=" + result +
                '}';
    }
}
