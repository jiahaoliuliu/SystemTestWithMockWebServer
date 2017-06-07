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
        mModel.generateNewNumber(new MainActivityContract.NumberGenerationCallback() {
            @Override
            public void onSuccess(int newNumber) {
                mView.showNumber(newNumber);
            }

            @Override
            public void onFailure() {
                // TODO: Show error
            }
        });
    }
}
