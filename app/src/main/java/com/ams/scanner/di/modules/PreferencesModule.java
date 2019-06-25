package com.ams.scanner.di.modules;

import android.content.Context;
import com.ams.scanner.data.local.preference.AppPreferencesHelper;
import com.ams.scanner.data.local.preference.CommonPreferencesHelper;
import com.ams.scanner.data.local.preference.PreferencesHelper;
import com.ams.scanner.di.qualifiers.ApplicationContext;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    @Provides
    @ApplicationScope
    static PreferencesHelper provideApplicationPreferences(
            CommonPreferencesHelper commonPreferencesHelper) {
        return new AppPreferencesHelper(commonPreferencesHelper);
    }

    @Provides
    @ApplicationScope
    static CommonPreferencesHelper providePreferencesHelper(
            @ApplicationContext Context context) {
        return new CommonPreferencesHelper(context);
    }
}
