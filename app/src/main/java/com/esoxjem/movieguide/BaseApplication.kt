package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
import com.esoxjem.movieguide.di.ListingComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author arun
 */
class BaseApplication : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent
    private var listingComponent: ListingComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}
