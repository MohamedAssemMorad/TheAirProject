package com.example.theair.presentation.di

import com.example.theair.data.network.MovieAPIController
import com.example.theair.data.repository.MovieRepository
import com.example.theair.presentation.viewmodel.MovieCreditsViewModel
import com.example.theair.presentation.viewmodel.MovieDetailsViewModel
import com.example.theair.presentation.viewmodel.MovieListViewModel
import com.example.theair.presentation.viewmodel.MovieRecommendationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val networkModule = module {
    single { MovieAPIController }
}

val repositoryModule = module {
    single { MovieRepository(get()) }
}

val viewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailsViewModel(get()) }
    viewModel { MovieCreditsViewModel(get()) }
    viewModel { MovieRecommendationsViewModel(get()) }
}