package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.MovieDetailsFragmentSubcomponent
import com.esoxjem.movieguide.di.MoviesListingFragmentSubcomponent
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author arun
 */
class BaseApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent
    private var movieDetailsFragmentSubcomponent: MovieDetailsFragmentSubcomponent? = null
    private var moviesListingFragmentSubcomponent: MoviesListingFragmentSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.create()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    fun createDetailsComponent(): MovieDetailsFragmentSubcomponent = appComponent.plus(DetailsModule())

    fun releaseDetailsComponent() {
        movieDetailsFragmentSubcomponent = null
    }

    fun createListingComponent(): MoviesListingFragmentSubcomponent = appComponent.plus(ListingModule())

    fun releaseListingComponent() {
        moviesListingFragmentSubcomponent = null
    }
}
