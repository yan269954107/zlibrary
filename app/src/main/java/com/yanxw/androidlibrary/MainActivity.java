package com.yanxw.androidlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yanxw.zlibrary.LoadingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends LoadingActivity<MainPresenter> implements MainView {

    @BindView(R.id.button3)
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

    @Override
    public int provideLayout() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.button3)
    public void test(View view) {
        getPresenter().showStr();
    }

    @Override
    public void showStr(String str) {
        mBtn.setText(str);
    }
}
