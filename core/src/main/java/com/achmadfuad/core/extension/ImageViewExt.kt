package com.achmadfuad.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(img: String?) {
    Glide.with(this).load(img).into(this)
}

fun ImageView.loadImageWithRadius(img: String?) {
    val requestOptions = RequestOptions()
    requestOptions.transforms(CenterCrop(), RoundedCorners(12))

    Glide.with(this).load(img).apply(requestOptions).into(this)
}