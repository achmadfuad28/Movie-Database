package com.achmadfuad.moviedatabase.module

import com.achmadfuad.moviedatabase.presentation.detail.DetailViewModel
import com.achmadfuad.moviedatabase.presentation.main.favorite.FavoriteViewModel
import com.achmadfuad.moviedatabase.presentation.main.home.HomeViewModel
import com.achmadfuad.moviedatabase.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(movieUseCase = get()) }
    viewModel { DetailViewModel(movieDetailUseCase = get(), localSource = get(), getFavoriteMovieUseCase = get()) }
    viewModel { FavoriteViewModel(getFavoriteMovieUseCase = get()) }
    viewModel { SearchViewModel(movieUseCase = get()) }
}
