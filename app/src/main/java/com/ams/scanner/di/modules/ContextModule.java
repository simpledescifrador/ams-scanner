package com.ams.scanner.di.modules;

import android.content.Context;
import com.ams.scanner.di.qualifiers.ApplicationContext;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context provideContext() {
        return context;
    }
}
