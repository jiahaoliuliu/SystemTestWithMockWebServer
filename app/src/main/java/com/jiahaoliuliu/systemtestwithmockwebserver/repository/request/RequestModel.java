package com.jiahaoliuliu.systemtestwithmockwebserver.repository.request;

/**
 * Created by jiahaoliu on 6/7/17.
 */

//{
//    "jsonrpc": "2.0",
//    "method": "generateIntegers",
//    "params": {
//        "apiKey": "999b69a8-f93d-4edf-8fc0-f5aa29ca04e0",
//        "n": 1,
//        "min": 1,
//        "max": 1000
//        },
//    "id": 42
//}
public class RequestModel {

    private int id = 42;
    private String jsonrpc = "2.0";
    private String method = "generateIntegers";
    private Params params;

    public RequestModel(Params params) {
        this.params = params;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestModel that = (RequestModel) o;

        if (id != that.id) return false;
        if (jsonrpc != null ? !jsonrpc.equals(that.jsonrpc) : that.jsonrpc != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        return params != null ? params.equals(that.params) : that.params == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jsonrpc != null ? jsonrpc.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "id=" + id +
                ", jsonrpc='" + jsonrpc + '\'' +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }
}
