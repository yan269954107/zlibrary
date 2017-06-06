package com.yanxw.zlibrary.mvp;

/**
 * RxCallback
 * Created by yanxinwei on 2017/6/6.
 */

public abstract class RxCallback<T> {

    abstract void processData(T value);

    abstract void processError(Throwable e);

    abstract void onComplete();

}
