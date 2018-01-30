package com.esoxjem.movieguide

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

open class Movie : Parcelable {

    var id: String? = null
    var overview: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("poster_path")
    var posterPath: String? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
    var title: String? = null
    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()

    protected constructor(inParcel: Parcel) {
        id = inParcel.readString()
        overview = inParcel.readString()
        releaseDate = inParcel.readString()
        posterPath = inParcel.readString()
        backdropPath = inParcel.readString()
        title = inParcel.readString()
        voteAverage = inParcel.readDouble()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(id)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeString(posterPath)
        parcel.writeString(backdropPath)
        parcel.writeString(title)
        parcel.writeDouble(voteAverage)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {

            override fun createFromParcel(inParcel: Parcel): Movie {
                return Movie(inParcel)
            }

            override fun newArray(size: Int): Array<Movie> {
                return newArray(size)
            }
        }
    }
}
