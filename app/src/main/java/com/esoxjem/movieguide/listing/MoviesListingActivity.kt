package com.esoxjem.movieguide.listing

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.FrameLayout
import com.esoxjem.movieguide.Constants
import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.R
import com.esoxjem.movieguide.details.MovieDetailsActivity
import com.esoxjem.movieguide.details.MovieDetailsFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MoviesListingActivity : AppCompatActivity(), MoviesListingFragment.Callback, HasSupportFragmentInjector {

    @Inject lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    private var twoPaneMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()

        if (findViewById<FrameLayout>(R.id.movie_details_container) != null) {
            twoPaneMode = true

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.movie_details_container, MovieDetailsFragment())
                        .commit()
            }
        } else {
            twoPaneMode = false
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar?.setTitle(R.string.movie_guide)
            supportActionBar?.setDisplayShowTitleEnabled(true)
        }
    }

    override fun onMoviesLoaded(movie: Movie) {
        if (twoPaneMode) {
            loadMovieFragment(movie)
        } else {
            // Do not load in single pane moviesListingView
        }
    }

    override fun onMovieClicked(movie: Movie) {
        if (twoPaneMode) {
            loadMovieFragment(movie)
        } else {
            startMovieActivity(movie)
        }
    }

    private fun startMovieActivity(movie: Movie) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        val extras = Bundle()
        extras.putParcelable(Constants.MOVIE, movie)
        intent.putExtras(extras)
        startActivity(intent)
    }

    private fun loadMovieFragment(movie: Movie) {
        val movieDetailsFragment = MovieDetailsFragment.getInstance(movie)
        supportFragmentManager.beginTransaction()
                .replace(R.id.movie_details_container, movieDetailsFragment, DETAILS_FRAGMENT)
                .commit()
    }

    companion object {

        val DETAILS_FRAGMENT = "DetailsFragment"
    }

}
