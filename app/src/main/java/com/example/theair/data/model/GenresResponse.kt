package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class GenresResponse(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null
)