package com.asantivanezg.paginationexercise.data.remote.interceptor

import android.content.Context
import com.asantivanezg.paginationexercise.util.addBearer
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class TokenInterceptor @Inject constructor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.addHeader("Authorization", addBearer(BuildConfig.TOKEN))

        return chain.proceed(requestBuilder.build())
    }

}