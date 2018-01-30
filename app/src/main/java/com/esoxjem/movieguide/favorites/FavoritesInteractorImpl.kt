package com.esoxjem.movieguide.favorites


import com.esoxjem.movieguide.Movie

import java.io.IOException
import java.util.ArrayList

/**
 * @author arun
 */
class FavoritesInteractorImpl(private val favoritesStore: FavoritesStore) : FavoritesInteractor {

    override val favorites: List<Movie>
        get() = try {
            favoritesStore.favorites
        } catch (ignored: IOException) {
            ArrayList(0)
        }

    override fun setFavorite(movie: Movie?) {
        favoritesStore.setFavorite(movie)
    }

    override fun isFavorite(id: String?): Boolean {
        return favoritesStore.isFavorite(id)
    }

    override fun unFavorite(id: String?) {
        favoritesStore.unfavorite(id)
    }
}
