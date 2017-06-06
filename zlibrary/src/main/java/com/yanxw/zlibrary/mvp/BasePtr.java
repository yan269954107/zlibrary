package com.yanxw.zlibrary.mvp;

import com.yanxw.zlibrary.rx.RxUtils;

import io.reactivex.disposables.CompositeDisposable;

/**
 * BasePtr
 * Created by yanxinwei on 2017/6/2.
 */

public abstract class BasePtr<V extends BaseView> {

    private V mView;
    protected CompositeDisposable mDisposable = new CompositeDisposable();

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        RxUtils.dispose(mDisposable);
        mView = null;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }

}
