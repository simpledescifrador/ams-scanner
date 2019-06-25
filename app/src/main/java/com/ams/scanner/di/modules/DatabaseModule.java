package com.ams.scanner.di.modules;

import com.ams.scanner.data.local.db.AppDbHelper;
import com.ams.scanner.data.local.db.DbHelper;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class DatabaseModule {

    @Provides
    @ApplicationScope
    static DbHelper provideDbHelper() {
        return new AppDbHelper();
    }
}
