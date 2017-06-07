package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

import android.support.annotation.NonNull;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    public MainActivityPresenter(@NonNull MainActivityContract.View view) {
        this.mView = view;
        this.mModel = new MainActivityModel();
    }

    @Override
    public void getNewNumber() {
        int newNumber = mModel.generateNewNumber();
        mView.showNumber(newNumber);
    }
}
