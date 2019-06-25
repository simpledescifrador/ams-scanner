package com.ams.scanner.di.components;

import com.ams.scanner.di.modules.ActivityFragmentModule;
import com.ams.scanner.di.scopes.ActivityScope;
import com.ams.scanner.ui.main.MainActivity;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityFragmentModule.class)
public interface ActivityFragmentComponent {

    void inject(MainActivity mainActivity);
}
