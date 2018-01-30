package com.esoxjem.movieguide.favorites


import com.esoxjem.movieguide.Movie

interface FavoritesInteractor {

    val favorites: List<Movie>
    fun setFavorite(movie: Movie?)
    fun isFavorite(id: String?): Boolean
    fun unFavorite(id: String?)

}
