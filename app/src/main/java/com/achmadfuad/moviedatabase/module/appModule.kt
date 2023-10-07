package com.achmadfuad.moviedatabase.module

import com.achmadfuad.data.module.mapperModule
import com.achmadfuad.data.module.repositoryModule
import com.achmadfuad.data.module.serviceModule

val appModule = listOf(
    networkModule,
    serviceModule,
    mapperModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)