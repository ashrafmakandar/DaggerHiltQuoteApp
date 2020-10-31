package com.kalyani.quotesapp.model


import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("author")
    val author: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("id")
    val id: String
)