package com.example.theair.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.theair.data.model.MovieCreditsResponse
import com.example.theair.data.repository.MovieRepository

public class MovieCreditsViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun callGetMovieCredits(
        id: Int
    ): LiveData<MovieCreditsResponse?> {
        return repository.callGetMovieCredits(id)
    }
}