package com.jiahaoliuliu.systemtestwithmockwebserver.repository.request;

import com.jiahaoliuliu.systemtestwithmockwebserver.ApiKeys;

/**
 * Created by jiahaoliu on 6/8/17.
 *
 * "params": {
 *    "apiKey": "999b69a8-f93d-4edf-8fc0-f5aa29ca04e0",
 *    "n": 1,
 *    "min": 1,
 *    "max": 1000
 *    },
 */
public class Params {
    private String apiKey = ApiKeys.RANDOM_ORG;
    private String n;
    private String min;
    private String max;

    public Params(String n, String min, String max) {
        this.n = n;
        this.min = min;
        this.max = max;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Params params = (Params) o;

        if (n != null ? !n.equals(params.n) : params.n != null) return false;
        if (min != null ? !min.equals(params.min) : params.min != null) return false;
        return max != null ? max.equals(params.max) : params.max == null;

    }

    @Override
    public int hashCode() {
        int result = n != null ? n.hashCode() : 0;
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Params{" +
                "n='" + n + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
