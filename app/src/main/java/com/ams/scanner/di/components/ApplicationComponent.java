package com.ams.scanner.di.components;

import android.content.Context;
import com.ams.scanner.MyApplication;
import com.ams.scanner.data.DataManager;
import com.ams.scanner.di.modules.ApplicationModule;
import com.ams.scanner.di.qualifiers.ApplicationContext;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Component;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    DataManager getDataManager();

    void inject(MyApplication application);
}
