package com.example.theair.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.theair.data.model.MovieDetailResponse
import com.example.theair.data.model.MovieResponse
import com.example.theair.data.repository.MovieRepository

public class MovieDetailsViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun callGetMovieDetails(
        id: Int
    ): LiveData<MovieDetailResponse?> {
        return repository.callGetMovieDetails(id)
    }
}