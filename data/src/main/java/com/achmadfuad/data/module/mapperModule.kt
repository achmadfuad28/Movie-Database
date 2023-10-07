package com.achmadfuad.data.module

import com.achmadfuad.data.mapper.*
import org.koin.dsl.module

val mapperModule = module {
    factory { MovieMapper() }
}