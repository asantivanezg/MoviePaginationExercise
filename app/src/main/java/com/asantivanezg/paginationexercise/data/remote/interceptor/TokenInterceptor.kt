package com.asantivanezg.paginationexercise.data.remote.interceptor

import com.asantivanezg.paginationexercise.BuildConfig
import com.asantivanezg.paginationexercise.util.addBearer
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class TokenInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.addHeader("Authorization", addBearer(BuildConfig.TOKEN))

        return chain.proceed(requestBuilder.build())
    }

}