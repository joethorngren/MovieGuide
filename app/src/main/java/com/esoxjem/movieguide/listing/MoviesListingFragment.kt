package com.esoxjem.movieguide.listing


import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.R
import dagger.android.support.AndroidSupportInjection
import java.util.*
import javax.inject.Inject

class MoviesListingFragment : Fragment(), MoviesListingView {

    @Inject lateinit var moviesPresenter: MoviesListingPresenter

    @BindView(R.id.movies_listing) lateinit var moviesListing: RecyclerView

    private lateinit var adapter: RecyclerView.Adapter<MoviesListingAdapter.ViewHolder>

    private val movies = ArrayList<Movie>(20)
    private var callback: Callback? = null
    private var unbinder: Unbinder? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        callback = context as Callback?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies, container, false)
        unbinder = ButterKnife.bind(this, rootView)
        initLayoutReferences()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesPresenter.setView(this)
    }

    private fun initLayoutReferences() {
        moviesListing.setHasFixedSize(true)

        val columns: Int
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columns = 2
        } else {
            columns = resources.getInteger(R.integer.no_of_columns)
        }
        val layoutManager = GridLayoutManager(activity, columns)

        moviesListing.layoutManager = layoutManager
        adapter = MoviesListingAdapter(movies, this)
        moviesListing.adapter = adapter
    }

    override fun showMovies(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        moviesListing.visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
        callback?.onMoviesLoaded(movies[0])
    }

    override fun loadingStarted() {
        Snackbar.make(moviesListing, R.string.loading_movies, Snackbar.LENGTH_SHORT).show()
    }

    override fun loadingFailed(errorMessage: String?) {
        Snackbar.make(moviesListing, errorMessage ?: "Error message == null", Snackbar.LENGTH_INDEFINITE).show()
    }

    override fun onMovieClicked(movie: Movie) {
        callback?.onMovieClicked(movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moviesPresenter.destroy()
        unbinder?.unbind()
    }

    override fun onDetach() {
        callback = null
        super.onDetach()
    }

    interface Callback {

        fun onMoviesLoaded(movie: Movie)

        fun onMovieClicked(movie: Movie)
    }
}
