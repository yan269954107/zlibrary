package com.yanxw.zlibrary.mvp;

/**
 * ShowErrorPtr
 * Created by yanxinwei on 2017/6/5.
 */

public class ShowErrorPtr<V extends ShowErrorView> extends BasePtr<V> {

    public void showError(String msg) {
        if (isViewAttached()) {
            getView().showError(msg);
        }
    }

}
