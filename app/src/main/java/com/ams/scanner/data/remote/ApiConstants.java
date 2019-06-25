package com.ams.scanner.data.remote;

import okhttp3.Credentials;

public class ApiConstants {

    /*------- API HEADERS -------------*/
    //Base Urls
    public static final String BASE_URL = "http://192.168.43.35/ams/";

    public static final String API_KEY = "5D95495CFBE5500D87D505A2AD13E70091816046";

    public static final String CONTENT_TYPE = "application/json";

    public static final String AUTHORIZATION = Credentials.basic("admin", "1234");

    /*------- END OF API HEADERS -------------*/
    static final String CHECK_QRCODE_STATUS_URL = "api/v1/qrcode/";
    static final String ADD_ATTENDANCE_URL = "api/v1/attendance/add";

    /* -------------  API URL'S ------------ */

}
