package com.example.theair.data.repository

import androidx.lifecycle.LiveData
import com.example.theair.data.model.MovieCreditsResponse
import com.example.theair.data.model.MovieDetailResponse
import com.example.theair.data.model.MovieRecommendationsResponse
import com.example.theair.data.model.MovieResponse
import com.example.theair.data.network.MovieAPIController

open class MovieRepository(private val apiController: MovieAPIController) {

    fun callGetMovieList(
        id: Int,
        pageNum: Int,
        sortBy: String
    ): LiveData<MovieResponse?> {
        return (apiController).getMovieList(id, pageNum, sortBy)
    }

    fun callGetMovieDetails(
        id: Int
    ): LiveData<MovieDetailResponse?> {
        return (apiController).getMovieDetails(id)
    }

    fun callGetMovieCredits(
        id: Int
    ): LiveData<MovieCreditsResponse?> {
        return (apiController).getMovieCredits(id)
    }

    fun callGetMovieRecommendations(
        id: Int
    ): LiveData<MovieRecommendationsResponse?> {
        return (apiController).getMovieRecommendations(id)
    }

}