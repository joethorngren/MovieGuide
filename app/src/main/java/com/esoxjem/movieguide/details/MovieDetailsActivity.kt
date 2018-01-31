package com.esoxjem.movieguide.details

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.esoxjem.movieguide.Constants
import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.R
import dagger.android.support.DaggerAppCompatActivity

class MovieDetailsActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        if (savedInstanceState == null) {
            val extras = intent.extras
            if (extras != null && extras.containsKey(Constants.MOVIE)) {
                val movie = extras.getParcelable<Movie>(Constants.MOVIE)
                if (movie != null) {
                    val movieDetailsFragment = MovieDetailsFragment.getInstance(movie)

                    supportFragmentManager.beginTransaction()
                            .add(R.id.movie_details_container, movieDetailsFragment)
                            .commit()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }
}
