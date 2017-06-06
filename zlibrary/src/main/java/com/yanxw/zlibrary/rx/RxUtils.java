package com.yanxw.zlibrary.rx;

import io.reactivex.CompletableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * RxUtils
 * Created by yanxinwei on 2017/6/5.
 */

public class RxUtils {

    public static void dispose(Disposable subscription) {
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

    public static <T> ObservableTransformer<T, T> schedule() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread(), true);
    }

    public static <T> ObservableTransformer<T, T> scheduleComputation() {
        return upstream -> upstream.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread(), true);
    }

    public static CompletableTransformer completableSchedule() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> MaybeTransformer<T, T> maybeSchedule() {
        return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

}
