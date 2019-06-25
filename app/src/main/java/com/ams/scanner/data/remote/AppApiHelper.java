package com.ams.scanner.data.remote;

import javax.inject.Inject;

public class AppApiHelper implements ApiHelper {
    private ApiInterface mApiInterface;

    @Inject
    public AppApiHelper(final ApiInterface apiInterface) {
        mApiInterface = apiInterface;
    }
}
