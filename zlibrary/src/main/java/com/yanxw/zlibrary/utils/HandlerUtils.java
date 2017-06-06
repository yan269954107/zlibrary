package com.yanxw.zlibrary.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * HandlerUtils
 * Created by yanxinwei on 2017/6/5.
 */

public final class HandlerUtils {

    public final static Handler MAIN = new Handler(Looper.getMainLooper());

    public static void postMain(Runnable runnable) {
        MAIN.post(runnable);
    }

    public static void postMainDelayed(Runnable runnable, long delayMillis) {
        MAIN.postDelayed(runnable, delayMillis);
    }

}
