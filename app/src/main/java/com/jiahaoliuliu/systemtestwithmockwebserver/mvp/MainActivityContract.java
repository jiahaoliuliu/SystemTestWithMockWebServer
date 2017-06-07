package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

/**
 * Created by jiahaoliu on 6/8/17.
 */

public class MainActivityContract {

    public interface View {
        void showNumber(int number);
    }

    public interface Presenter {
        void getNewNumber();
    }

    public interface Model {
        void generateNewNumber(NumberGenerationCallback numberGenerationCallback);
    }

    public interface NumberGenerationCallback {
        // If the data was correctly received
        void onSuccess(int numNumber);

        // If there were some error receiving the data
        void onFailure();
    }
}
