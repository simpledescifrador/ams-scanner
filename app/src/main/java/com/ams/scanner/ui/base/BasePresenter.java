package com.ams.scanner.ui.base;

import android.support.annotation.NonNull;
import com.ams.scanner.data.DataManager;
import com.ams.scanner.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends BaseMvpView> implements Presenter<V> {

    public static class MvpViewNotAttachedException extends RuntimeException {

        MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(BaseMvpView) before"
                    + " requesting data to the Presenter");
        }
    }

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Inject
    SchedulerProvider mSchedulerProvider;

    private DataManager mDataManager;

    private V mvpView;

    @Inject
    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(@NonNull V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
        mCompositeDisposable.dispose();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public V getMvpView() {
        return mvpView;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    protected void checkViewAttached() {
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }
}
