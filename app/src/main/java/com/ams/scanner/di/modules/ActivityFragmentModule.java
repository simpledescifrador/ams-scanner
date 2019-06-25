package com.ams.scanner.di.modules;

import android.app.Activity;
import android.content.Context;
import com.ams.scanner.di.qualifiers.ActivityContext;
import dagger.Module;
import dagger.Provides;

@Module(includes = {RxModule.class})
public class ActivityFragmentModule {

    private Activity activity;

    public ActivityFragmentModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activity;
    }


}
