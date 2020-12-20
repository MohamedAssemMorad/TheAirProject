package com.example.theair.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.theair.data.model.MovieCreditsResponse
import com.example.theair.data.model.MovieRecommendationsResponse
import com.example.theair.data.repository.MovieRepository

public class MovieRecommendationsViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun callGetMovieRecommendations(
        id: Int
    ): LiveData<MovieRecommendationsResponse?> {
        return repository.callGetMovieRecommendations(id)
    }
}