package com.kalyani.quotesapp.model.allquotesmodel


import com.google.gson.annotations.SerializedName

data class AllQuoteItem(
    @SerializedName("addedBy")
    val addedBy: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("numberOfVotes")
    val numberOfVotes: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("source")
    val source: String,
    @SerializedName("sr")
    val sr: String,
    @SerializedName("__v")
    val v: Int
)