package com.ams.scanner.data;

import com.ams.scanner.data.local.db.DbHelper;
import com.ams.scanner.data.local.preference.PreferencesHelper;
import com.ams.scanner.data.remote.ApiHelper;

public interface DataManager extends DbHelper, ApiHelper, PreferencesHelper {

}
