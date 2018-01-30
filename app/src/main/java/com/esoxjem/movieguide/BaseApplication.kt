package com.esoxjem.movieguide

import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.DetailsComponent
import com.esoxjem.movieguide.di.ListingComponent
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author arun
 */
class BaseApplication : DaggerApplication() {

    private lateinit var appComponent: AppComponent
    private var detailsComponent: DetailsComponent? = null
    private var listingComponent: ListingComponent? = null

    override fun onCreate() {
        super.onCreate()
        applicationInjector()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().build()

        return appComponent
    }

    fun createDetailsComponent(): DetailsComponent = appComponent.plus(DetailsModule())

    fun releaseDetailsComponent() {
        detailsComponent = null
    }

    fun createListingComponent(): ListingComponent = appComponent.plus(ListingModule())

    fun releaseListingComponent() {
        listingComponent = null
    }
}
