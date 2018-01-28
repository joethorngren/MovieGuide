package com.esoxjem.movieguide

import android.app.Application

import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.DetailsComponent
import com.esoxjem.movieguide.di.ListingComponent
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule

/**
 * @author arun
 */
class BaseApplication : Application() {
    private var appComponent: AppComponent? = null
    private var detailsComponent: DetailsComponent? = null
    var listingComponent: ListingComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    fun createDetailsComponent(): DetailsComponent? {
        detailsComponent = appComponent!!.plus(DetailsModule())
        return detailsComponent
    }

    fun releaseDetailsComponent() {
        detailsComponent = null
    }

    fun createListingComponent(): ListingComponent? {
        listingComponent = appComponent!!.plus(ListingModule())
        return listingComponent
    }

    fun releaseListingComponent() {
        listingComponent = null
    }
}
