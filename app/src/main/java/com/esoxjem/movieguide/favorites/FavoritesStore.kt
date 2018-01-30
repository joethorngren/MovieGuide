package com.esoxjem.movieguide.favorites


import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

import com.esoxjem.movieguide.Movie
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

import java.io.IOException
import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author arun
 */
@Singleton
class FavoritesStore @Inject constructor(context: Context) {

    private val pref: SharedPreferences

    // Do nothing;
    val favorites: List<Movie>
        @Throws(IOException::class)
        get() {
            val allEntries = pref.all
            val movies = ArrayList<Movie>(24)
            val moshi = Moshi.Builder().build()

            for ((key) in allEntries) {
                val movieJson = pref.getString(key, null)

                if (!TextUtils.isEmpty(movieJson)) {
                    val jsonAdapter = moshi.adapter(Movie::class.java)

                    val movie = jsonAdapter.fromJson(movieJson!!)
                    movies.add(movie)
                } else {
                }
            }
            return movies
        }

    init {
        pref = context.applicationContext
                .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun setFavorite(movie: Movie?) {
        val editor = pref.edit()
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(Movie::class.java)
        val movieJson = jsonAdapter.toJson(movie)
        editor.putString(movie?.id, movieJson)
        editor.apply()
    }

    fun isFavorite(id: String?): Boolean {
        val movieJson = pref.getString(id, null)

        return !TextUtils.isEmpty(movieJson)
    }

    fun unfavorite(id: String?) {
        val editor = pref.edit()
        editor.remove(id)
        editor.apply()
    }

    companion object {

        private val PREF_NAME = "FavoritesStore"
    }
}

