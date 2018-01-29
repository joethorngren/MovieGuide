package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.components.AppComponent
import com.esoxjem.movieguide.di.components.DaggerAppComponent
import com.esoxjem.movieguide.di.components.DetailsComponent
import com.esoxjem.movieguide.di.components.ListingComponent
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
    private var detailsComponent: DetailsComponent? = null
    private var listingComponent: ListingComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
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
