package com.ams.scanner;

import android.app.Application;
import com.ams.scanner.di.components.ApplicationComponent;
import com.ams.scanner.di.components.DaggerApplicationComponent;
import com.ams.scanner.di.modules.ApplicationModule;
import com.ams.scanner.di.modules.ContextModule;

public class MyApplication extends Application {

    public static ApplicationComponent mApplicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationDaggerComponent();
    }

    private void initApplicationDaggerComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .contextModule(new ContextModule(this))
                .build();

        mApplicationComponent.inject(this);
    }
}
