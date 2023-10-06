package com.achmadfuad.moviedatabase.presentation.main.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "You don't have any favorite movies"
    }
    val text: LiveData<String> = _text
}