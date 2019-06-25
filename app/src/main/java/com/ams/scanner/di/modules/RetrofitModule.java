package com.ams.scanner.di.modules;


import com.ams.scanner.data.remote.ApiConstants;
import com.ams.scanner.data.remote.ApiHelper;
import com.ams.scanner.data.remote.ApiInterface;
import com.ams.scanner.data.remote.AppApiHelper;
import com.ams.scanner.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @ApplicationScope
    static ApiHelper provideApiHelper(ApiInterface apiInterface) {
        return new AppApiHelper(apiInterface);
    }

    @Provides
    @ApplicationScope
    static ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @ApplicationScope
    static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @ApplicationScope
    static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {
                Request request = chain.request();

                Builder builder = request.newBuilder()
                        .addHeader("X-API-KEY", ApiConstants.API_KEY)
                        .addHeader("Content-Type", ApiConstants.CONTENT_TYPE)
                        .addHeader("Authorization", ApiConstants.AUTHORIZATION);
                return chain.proceed(builder.build());
            }
        }).addInterceptor(httpLoggingInterceptor);

        return builder.build();
    }

    @Provides
    @ApplicationScope
    static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
