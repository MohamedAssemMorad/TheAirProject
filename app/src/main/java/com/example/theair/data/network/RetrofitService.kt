package com.example.theair.data.network

import com.example.theair.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("4/list/{id}")
    fun callGetMovieList(@Path("id") id: Int?): Call<MovieResponse?>
}
