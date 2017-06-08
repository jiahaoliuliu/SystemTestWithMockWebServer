package com.jiahaoliuliu.systemtestwithmockwebserver.repository.response;

/**
 * Created by jiahaoliu on 6/8/17.
 * {
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
 *  }
 */
public class Result {

    private Random random;
    private int bitsUsed;
    private int requestsLeft;
    private int advisoryDelay;

    public Result() {
    }

    public Result(Random random, int bitsUsed, int requestsLeft, int advisoryDelay) {
        this.random = random;
        this.bitsUsed = bitsUsed;
        this.requestsLeft = requestsLeft;
        this.advisoryDelay = advisoryDelay;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getBitsUsed() {
        return bitsUsed;
    }

    public void setBitsUsed(int bitsUsed) {
        this.bitsUsed = bitsUsed;
    }

    public int getRequestsLeft() {
        return requestsLeft;
    }

    public void setRequestsLeft(int requestsLeft) {
        this.requestsLeft = requestsLeft;
    }

    public int getAdvisoryDelay() {
        return advisoryDelay;
    }

    public void setAdvisoryDelay(int advisoryDelay) {
        this.advisoryDelay = advisoryDelay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (bitsUsed != result.bitsUsed) return false;
        if (requestsLeft != result.requestsLeft) return false;
        if (advisoryDelay != result.advisoryDelay) return false;
        return random != null ? random.equals(result.random) : result.random == null;

    }

    @Override
    public int hashCode() {
        int result = random != null ? random.hashCode() : 0;
        result = 31 * result + bitsUsed;
        result = 31 * result + requestsLeft;
        result = 31 * result + advisoryDelay;
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "random=" + random +
                ", bitsUsed=" + bitsUsed +
                ", requestsLeft=" + requestsLeft +
                ", advisoryDelay=" + advisoryDelay +
                '}';
    }
}
