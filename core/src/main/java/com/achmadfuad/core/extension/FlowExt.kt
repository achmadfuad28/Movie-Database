package com.achmadfuad.core.extension

import com.achmadfuad.core.data.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

fun <T> Flow<Resource<T>>.onProgress() =
    onStart {
        emit(Resource.Loading(true))
    }.onCompletion {
        emit(Resource.Loading(false))
    }

fun <T> Flow<Resource<T>>.catchError() =
    catch { error ->
        emit(Resource.Error(Throwable(message = error.message)))
        emit(Resource.Loading(false))
    }
        .flowOn(Dispatchers.IO)
