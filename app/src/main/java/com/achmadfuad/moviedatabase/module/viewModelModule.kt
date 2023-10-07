package com.achmadfuad.moviedatabase.module

import com.achmadfuad.moviedatabase.presentation.detail.DetailViewModel
import com.achmadfuad.moviedatabase.presentation.main.favorite.FavoriteViewModel
import com.achmadfuad.moviedatabase.presentation.main.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(movieUseCase = get()) }
    viewModel { DetailViewModel(movieDetailUseCase = get(), localSource = get()) }
    viewModel { FavoriteViewModel(getFavoriteMovieUseCase = get()) }
}
