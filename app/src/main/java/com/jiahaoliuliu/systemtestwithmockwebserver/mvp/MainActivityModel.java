package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class MainActivityModel implements MainActivityContract.Model {

    // TODO: Request the data to the repository
    @Override
    public int generateNewNumber() {
        return 42;
    }
}
