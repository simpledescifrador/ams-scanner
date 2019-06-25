package com.ams.scanner.di.modules;

import com.ams.scanner.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class RxModule {

    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    static SchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }
}
