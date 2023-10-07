package com.achmadfuad.core.extension

import com.achmadfuad.core.network.Mapper
import com.achmadfuad.core.data.Resource

fun <A, B> A.mapTo(mapper: Mapper<A, B>): Resource<B> {
    return Resource.Success(mapper.to(this))
}
