package com.yanxw.zlibrary;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.elvishew.xlog.XLog;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * Created by yanxinwei on 2017/6/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayout());
        ButterKnife.bind(this);

        printActivityName();
    }

    public abstract int provideLayout();

    private void printActivityName() {
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        XLog.e("@@@@ActivityName:" + cn.getClassName());
    }
}
