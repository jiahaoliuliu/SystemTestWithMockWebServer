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
    private int n;
    private int min;
    private int max;

    public Params(int n, int min, int max) {
        this.n = n;
        this.min = min;
        this.max = max;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Params params = (Params) o;

        if (n != params.n) return false;
        if (min != params.min) return false;
        return max == params.max;

    }

    @Override
    public int hashCode() {
        int result = n;
        result = 31 * result + min;
        result = 31 * result + max;
        return result;
    }

    @Override
    public String toString() {
        return "Params{" +
                "n=" + n +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
