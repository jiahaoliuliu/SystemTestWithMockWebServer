package com.jiahaoliuliu.systemtestwithmockwebserver.repository.response;

import java.util.Arrays;

/**
 * Created by jiahaoliu on 6/8/17.
 *
 * {
 * "data": [
 *      863
 *  ],
 * "completionTime": "2017-06-08 13:01:39Z"
 * }
 */
public class Random {

    private int[] data;
    private String completionTime;

    public Random() {
    }

    public Random(int[] data, String completionTime) {
        this.data = data;
        this.completionTime = completionTime;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Random random = (Random) o;

        if (!Arrays.equals(data, random.data)) return false;
        return completionTime != null ? completionTime.equals(random.completionTime) : random.completionTime == null;

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + (completionTime != null ? completionTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Random{" +
                "data=" + Arrays.toString(data) +
                ", completionTime='" + completionTime + '\'' +
                '}';
    }
}
