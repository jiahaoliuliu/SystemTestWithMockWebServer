package com.jiahaoliuliu.systemtestwithmockwebserver.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiahaoliuliu.systemtestwithmockwebserver.R;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private TextView mNumberTv;
    private MainActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link the view
        mNumberTv = (TextView) findViewById(R.id.number_tv);

        // Init the variables
        mPresenter = new MainActivityPresenter(this);

        mNumberTv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mPresenter.getNewNumber();
            }
        });

    }

    @Override
    public void showNumber(int number) {
        mNumberTv.setText(String.valueOf(number));
    }
}
