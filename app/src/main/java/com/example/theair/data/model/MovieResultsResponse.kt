package com.example.theair.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieResultsResponse(

    @SerializedName("adult")
    val adult: String? = null,

    @SerializedName("backdrop_path")
    val backdrop_path: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("media_type")
    val media_type: String? = null,

    @SerializedName("original_language")
    val original_language: String? = null,

    @SerializedName("original_title")
    val original_title: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = null,

    @SerializedName("poster_path")
    val poster_path: String? = null,

    @SerializedName("release_date")
    val release_date: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("video")
    val video: Boolean? = null,

    @SerializedName("vote_average")
    val vote_average: Double? = null,

    @SerializedName("vote_count")
    val vote_count: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(adult)
        parcel.writeString(backdrop_path)
        parcel.writeValue(id)
        parcel.writeString(media_type)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(overview)
        parcel.writeValue(popularity)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeString(title)
        parcel.writeValue(video)
        parcel.writeValue(vote_average)
        parcel.writeValue(vote_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResultsResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResultsResponse {
            return MovieResultsResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResultsResponse?> {
            return arrayOfNulls(size)
        }
    }

}