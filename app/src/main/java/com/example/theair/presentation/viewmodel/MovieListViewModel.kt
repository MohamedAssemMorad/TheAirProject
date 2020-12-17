package com.example.theair.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.theair.data.model.MovieResponse
import com.example.theair.data.repository.MovieRepository

public class MovieListViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    fun callGetMovieList(id: Int): LiveData<MovieResponse?> {
        return repository.callGetMovieList(id)
    }
}