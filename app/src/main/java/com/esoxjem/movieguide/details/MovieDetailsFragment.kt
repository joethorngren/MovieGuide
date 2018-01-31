package com.esoxjem.movieguide.details


import android.content.Context
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.bumptech.glide.Glide
import com.esoxjem.movieguide.Api
import com.esoxjem.movieguide.Constants
import com.esoxjem.movieguide.Movie
import com.esoxjem.movieguide.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class MovieDetailsFragment : Fragment(), MovieDetailsView {

    @Inject
    lateinit var movieDetailsPresenter: MovieDetailsPresenter

    @BindView(R.id.movie_poster)
    lateinit var poster: ImageView
    @BindView(R.id.collapsing_toolbar)
    lateinit var collapsingToolbar: CollapsingToolbarLayout
    @BindView(R.id.movie_name)
    lateinit var title: TextView
    @BindView(R.id.movie_year)
    lateinit var releaseDate: TextView
    @BindView(R.id.movie_rating)
    lateinit var rating: TextView
    @BindView(R.id.movie_description)
    lateinit var overview: TextView
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.favorite)
    lateinit var favorite: FloatingActionButton

    private var movie: Movie? = null
    private var unbinder: Unbinder? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_movie_details, container, false)
        unbinder = ButterKnife.bind(this, rootView)
        setToolbar()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val movie = arguments?.get(Constants.MOVIE) as Movie
            this.movie = movie
            movieDetailsPresenter.setView(this)
            movieDetailsPresenter.showDetails(movie)
            movieDetailsPresenter.showFavoriteButton(movie)
        }
    }


    private fun setToolbar() {
        collapsingToolbar.setContentScrimColor(
            ContextCompat.getColor(context!!, R.color.colorPrimary))
        collapsingToolbar.title = getString(R.string.movie_details)
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar)
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar)
        collapsingToolbar.isTitleEnabled = true

        if (toolbar != null) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)

            val actionBar = (activity as AppCompatActivity).supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            // Don't inflate. Tablet is in landscape mode.
        }
    }

    override fun showDetails(movie: Movie) {
        Glide.with(context).load(Api.getBackdropPath(movie.backdropPath)).into(poster)
        title.text = movie.title
        releaseDate.text = String.format(getString(R.string.release_date), movie.releaseDate)
        rating.text = String.format(getString(R.string.rating), movie.voteAverage.toString())
        overview.text = movie.overview
    }


    override fun showFavorited() {
        favorite.setImageDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.ic_favorite_white_24dp))
    }

    override fun showUnFavorited() {
        favorite.setImageDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.ic_favorite_border_white_24dp))
    }

    @OnClick(R.id.favorite)
    fun onClick(view: View) {
        if (view.id == R.id.favorite) {
            onFavoriteClick()
        }
    }


    private fun onFavoriteClick() {
        movieDetailsPresenter.onFavoriteClick(movie)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movieDetailsPresenter.destroy()
        unbinder?.unbind()
    }

    companion object {

        fun getInstance(movie: Movie): MovieDetailsFragment {
            val args = Bundle()
            args.putParcelable(Constants.MOVIE, movie)
            val movieDetailsFragment = MovieDetailsFragment()
            movieDetailsFragment.arguments = args
            return movieDetailsFragment
        }
    }
}
