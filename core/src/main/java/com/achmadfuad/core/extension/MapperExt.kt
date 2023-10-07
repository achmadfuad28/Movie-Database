package com.achmadfuad.core.extension

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.core.data.Resource

fun <A, B> A.mapTo(mapper: Mapper<A, B>): Resource<B> {
    return Resource.Success(mapper.to(this))
}

fun <A, B> A.mappingTo(mapper: Mapper<A, B>): B {
    return mapper.to(this)
}
