package com.example.theair.data.network

import com.example.theair.data.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("4/list/{id}")
    fun callGetMovieList(
        @Path("id") id: Int?,
        @Query("page") pageNum: Int,
        @Query("sort_by") sortBy: String
    ): Call<MovieResponse?>

    @GET("3/movie/{movie_id}")
    fun callGetMovieDetails(
        @Path("movie_id") id: Int?
    ): Call<MovieDetailResponse?>

    @GET("3/movie/{movie_id}/credits")
    fun callGetMovieCredits(
        @Path("movie_id") id: Int?
    ): Call<MovieCreditsResponse?>

    @GET("3/movie/{movie_id}/recommendations")
    fun callGetMovieRecommendations(
        @Path("movie_id") id: Int?
    ): Call<MovieRecommendationsResponse?>
}
