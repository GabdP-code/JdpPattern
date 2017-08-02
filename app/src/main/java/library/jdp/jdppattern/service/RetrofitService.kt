package library.jdp.jdppattern.service

import android.content.Context
import library.jdp.jdppattern.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.NotNull
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by jamesdeperio on 6/20/2017.
 */

abstract class RetrofitService : RetrofitContract {
@NotNull
    private lateinit var retrofit: Retrofit
    internal var header: RetrofitHeaderInterceptor = RetrofitHeaderInterceptor()

    protected fun initialize(context: Context, service: Class<*>): Any? {
        val cacheSize = setCacheSize() * 1024 * 1024
        val okHttpClient: OkHttpClient
        val cache = Cache(context.cacheDir, cacheSize.toLong())
        if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
            okHttpClient = OkHttpClient.Builder()
                    .cache(cache)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .addInterceptor(header)
                    .build()
        }
        else {
            okHttpClient = OkHttpClient.Builder()
                    .cache(cache)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(header)
                    .build()
        }
        retrofit = Retrofit.Builder()
                .baseUrl(setBaseURL())
                .client(okHttpClient)
                .addConverterFactory(converterFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        return retrofit.create(service)
    }

    abstract fun converterFactory(): Converter.Factory?

  
    fun Long initConnectTimeout() {
        return 30;
    }

  
    fun Long initReadTimeout() {
        return 30;
    }

  
    public Long initWriteTimeout() {
        return 30;
    }
    fun addHeader(key: String, value: String) {
        header.key.add(key)
        header.value.add(value)
    }
}

