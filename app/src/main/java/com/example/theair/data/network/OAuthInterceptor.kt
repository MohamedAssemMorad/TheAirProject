package com.example.theair.data.network

import okhttp3.Interceptor

class OAuthInterceptor(private val tokenType: String, private val accessToken: String) :
    Interceptor {

    // here this fun is to add interceptor to each request send fro APIs
    // so we add our Auth at this interceptor 
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", "$tokenType $accessToken").build()

        return chain.proceed(request)
    }
}