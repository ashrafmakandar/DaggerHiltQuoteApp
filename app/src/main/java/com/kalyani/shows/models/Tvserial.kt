package com.kalyani.shows.models


import com.google.gson.annotations.SerializedName

data class Tvserial(
    @SerializedName("tvShow")
    val tvShow: TvShow
)