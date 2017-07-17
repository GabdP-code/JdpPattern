package library.jdp.jdppattern.service

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

/**
 * Created by jamesdeperio on 7/5/2017.
 */

class RetrofitHeaderInterceptor : Interceptor {
    var key: MutableList<String> = ArrayList()
    var value: MutableList<String> = ArrayList()

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
        //         .header("Authorization", "auth-value");
        for (x in key.indices) {
            requestBuilder.addHeader(key[x], value[x])
        }
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
