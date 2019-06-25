package com.ams.scanner.data;

import android.content.Context;
import com.ams.scanner.data.local.db.DbHelper;
import com.ams.scanner.data.local.preference.PreferencesHelper;
import com.ams.scanner.data.remote.ApiHelper;
import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private ApiHelper mApiHelper;

    private Context mContext;

    private DbHelper mDbHelper;

    private PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(final Context context, final ApiHelper apiHelper, final DbHelper dbHelper,
            final PreferencesHelper preferencesHelper) {
        mContext = context;
        mApiHelper = apiHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }
}
