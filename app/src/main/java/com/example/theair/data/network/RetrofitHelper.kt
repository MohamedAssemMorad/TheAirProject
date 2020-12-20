package com.example.theair.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// RetrofitHelper class is used to make a singlton from retrofit to user over the app to
// make network calls to APIs
object RetrofitHelper {

    private const val APP_BASE_URL = "https://api.themoviedb.org/"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    private const val ACCESS_TOKEN =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MDg5NDk2NTEzMjQzNTgwN2QwNzZlNmY3MDAwYTVkOSIsInN1YiI6IjU2ZjUwYjFiYzNhMzY4Mjc0MTAwMWM4NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9l8Jt_U8D0RpLZUh1bSP9W0aGSI7ZnSMr8ZMHAiA8r0"
    private var appInstance: RetrofitService? = null

    fun getInstance(): RetrofitService? {
        if (appInstance == null) {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(OAuthInterceptor("Bearer ", ACCESS_TOKEN))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            appInstance = retrofit.create(RetrofitService::class.java)
        }
        return appInstance
    }

}