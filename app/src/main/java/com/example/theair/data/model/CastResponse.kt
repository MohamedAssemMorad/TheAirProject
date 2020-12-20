package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class CastResponse(

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("profile_path")
    val profile_path: String? = null,

    @SerializedName("character")
    val character: String? = null

)
