package com.yanxw.androidlibrary;

import com.yanxw.zlibrary.mvp.BasePtr;

/**
 * MainPresenter
 * Created by yanxinwei on 2017/6/6.
 */

public class MainPresenter extends BasePtr<MainView> {

    private int num = 0;

    public void showStr() {
        String str = num++ + "";
        getView().showStr(str);
    }

}
