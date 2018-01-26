package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.DetailsComponent
import com.esoxjem.movieguide.di.ListingComponent
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import com.esoxjem.movieguide.favorites.FavoritesModule
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
    private var detailsComponent: DetailsComponent? = null
    var listingComponent: ListingComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent()
        appComponent.inject(this)
    }

    private fun initializeAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .favoritesModule(FavoritesModule())
                .build()
    }

    fun createDetailsComponent(): DetailsComponent = appComponent.plus(DetailsModule())
            .apply { detailsComponent = this }

    fun releaseDetailsComponent() {
        detailsComponent = null
    }

    fun createListingComponent(): ListingComponent = appComponent.plus(ListingModule())
            .apply { listingComponent }

    fun releaseListingComponent() {
        listingComponent = null
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}
