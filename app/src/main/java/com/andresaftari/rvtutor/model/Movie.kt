package com.andresaftari.rvtutor.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var title: String,
    var genre: String,
    var images: Int,
) : Parcelable
