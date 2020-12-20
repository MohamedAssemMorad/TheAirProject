package com.example.theair.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

    @SerializedName("backdrop_path")
    val backdrop_path: String? = null,

    @SerializedName("homepage")
    val homepage: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("original_title")
    val original_title: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("poster_path")
    val poster_path: String? = null,

    @SerializedName("release_date")
    val release_date: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("vote_average")
    val vote_average: Double? = null,

    @SerializedName("vote_count")
    val vote_count: Int? = null,

    @SerializedName("success")
    val success: Boolean? = true,

    @SerializedName("genres")
    val genres: ArrayList<GenresResponse>? = null
)