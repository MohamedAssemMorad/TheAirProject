package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsResponse(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("cast")
    val cast: ArrayList<CastResponse>? = null
)