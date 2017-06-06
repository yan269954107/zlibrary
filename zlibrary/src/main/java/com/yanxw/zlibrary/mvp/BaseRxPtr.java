package com.yanxw.zlibrary.mvp;

import com.yanxw.zlibrary.rx.RxUtils;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;

/**
 * BaseRxPtr
 * Created by yanxinwei on 2017/6/6.
 */

public class BaseRxPtr<V extends LoadingView> extends ShowErrorPtr<V> {

    public void subscribe(Observable<?> observable, RxCallback callback) {
        getView().showLoading();
        mDisposable.add(observable.compose(RxUtils.schedule())
                .subscribeWith(new DisposableObserver<Object>() {
                    @Override
                    public void onNext(Object value) {
                        getView().hideLoading();
                        callback.processData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        callback.processError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void subscribe(Completable completable, RxCallback callback) {
        getView().showLoading();
        mDisposable.add(completable.compose(RxUtils.completableSchedule())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onError(Throwable e) {
                        getView().hideLoading();
                        callback.processError(e);
                    }

                    @Override
                    public void onComplete() {
                        getView().hideLoading();
                        callback.onComplete();
                    }
                }));
    }

}
