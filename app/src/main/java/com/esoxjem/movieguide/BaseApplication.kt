package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.MovieDetailsFragmentSubcomponent
import com.esoxjem.movieguide.di.MoviesListingFragmentSubcomponent
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.MovieDetailsModule
import com.esoxjem.movieguide.di.modules.MoviesListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author arun
 */
class BaseApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent
    private var movieDetailsFragmentSubcomponent: MovieDetailsFragmentSubcomponent? = null
    private var moviesListingFragmentSubcomponent: MoviesListingFragmentSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    fun createDetailsComponent(): MovieDetailsFragmentSubcomponent = appComponent.plus(
        MovieDetailsModule())

    fun releaseDetailsComponent() {
        movieDetailsFragmentSubcomponent = null
    }

    fun createListingComponent(): MoviesListingFragmentSubcomponent = appComponent.plus(
        MoviesListingModule())

    fun releaseListingComponent() {
        moviesListingFragmentSubcomponent = null
    }
}
