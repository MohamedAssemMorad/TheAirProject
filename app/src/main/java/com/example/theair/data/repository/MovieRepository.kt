package com.example.theair.data.repository

import androidx.lifecycle.LiveData
import com.example.theair.data.model.MovieResponse
import com.example.theair.data.network.MovieAPIController

open class MovieRepository(private val apiController: MovieAPIController) {

    fun callGetMovieList(
        id: Int
    ): LiveData<MovieResponse?> {
        return (apiController).getMovieList(id)
    }

}