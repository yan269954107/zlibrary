package com.yanxw.zlibrary;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yanxw.zlibrary.mvp.BasePtr;
import com.yanxw.zlibrary.mvp.LoadingView;
import com.yanxw.zlibrary.utils.ToastUtils;

/**
 * LoadingActivity
 * Created by yanxinwei on 2017/6/5.
 */

public abstract class LoadingActivity<P extends BasePtr> extends BaseActivity implements LoadingView {

    private P mPresenter;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = providePresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.detachView();
    }

    public abstract P providePresenter();

    public P getPresenter() {
        return mPresenter;
    }

    public void showProgressDialog(boolean cancelable) {
        showProgressDialog(getString(R.string.loading), cancelable);
    }

    public void showProgressDialog() {
        showProgressDialog(getString(R.string.loading));
    }

    public void showProgressDialog(String info) {
        showProgressDialog(info, true);
    }

    public void showProgressDialog(String info, boolean cancelable) {
        showProgressDialog("", info, cancelable);
    }

    public void showProgressDialog(String title, String info, boolean cancelable) {
        if (!isFinishing()) {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(this, title, info, true, cancelable, dialogInterface -> onCanceled());
            } else {
                if (!mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }
            }
        }
    }

    public void hideProgressDialog() {
        if (!isFinished() && mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public boolean isFinished() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return isDestroyed();
        }
        return isFinishing();
    }

    //需要实现ProgressDialog 取消后的逻辑可以继承实现该方法
    public void onCanceled() {
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        hideProgressDialog();
    }

    @Override
    public void showError(String msg) {
        ToastUtils.showShort(this, msg);
    }
}
