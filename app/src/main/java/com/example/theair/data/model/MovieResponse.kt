package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("results")
    val results: ArrayList<MovieResultsResponse>? = null

    )