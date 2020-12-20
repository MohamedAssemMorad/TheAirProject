package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class MovieRecommendationsResponse(

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("results")
    val results: ArrayList<MovieResultsResponse>? = null

)