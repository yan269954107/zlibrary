package com.yanxw.zlibrary;

import android.support.multidex.MultiDexApplication;

import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

/**
 * BaseApplication
 * Created by yanxinwei on 2017/6/2.
 */

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        //X-LOG init
        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL : LogLevel.NONE)           // 指定日志级别，低于该级别的日志将不会被打印，默认为 LogLevel.ALL
                .tag("MY_TAG")                                         // 指定 TAG，默认为 "X-LOG"
                .t()                                                   // 允许打印线程信息，默认禁止
                .st(3)                                                 // 允许打印深度为2的调用栈信息，默认禁止
                .b()                                                   // 允许打印日志边框，默认禁止
                .build();
        XLog.init(config);
    }

    public static BaseApplication getInstance() {
        return sInstance;
    }
}
