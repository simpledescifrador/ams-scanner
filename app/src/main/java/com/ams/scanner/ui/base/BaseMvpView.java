package com.ams.scanner.ui.base;

import android.support.annotation.StringRes;

public interface BaseMvpView {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
