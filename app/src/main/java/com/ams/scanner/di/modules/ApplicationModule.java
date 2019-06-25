package com.ams.scanner.di.modules;

import android.app.Application;
import android.content.Context;
import com.ams.scanner.data.AppDataManager;
import com.ams.scanner.data.DataManager;
import com.ams.scanner.data.local.db.DbHelper;
import com.ams.scanner.data.local.preference.PreferencesHelper;
import com.ams.scanner.data.remote.ApiHelper;
import com.ams.scanner.di.qualifiers.ApplicationContext;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class, PreferencesModule.class, RetrofitModule.class, DatabaseModule.class})
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationScope
    static AppDataManager provideAppDataManager(@ApplicationContext Context context,
            PreferencesHelper preferencesHelper,
            DbHelper dbHelper,
            ApiHelper apiHelper) {
        return new AppDataManager(context, apiHelper, dbHelper, preferencesHelper);
    }

    @Provides
    @ApplicationScope
    static DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }
}
