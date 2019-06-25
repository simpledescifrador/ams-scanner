package com.ams.scanner.data.local.preference;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private CommonPreferencesHelper commonPreferencesHelper;

    @Inject
    public AppPreferencesHelper(final CommonPreferencesHelper commonPreferencesHelper) {
        this.commonPreferencesHelper = commonPreferencesHelper;
    }
}
