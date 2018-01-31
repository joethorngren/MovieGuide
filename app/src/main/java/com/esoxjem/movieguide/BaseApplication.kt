package com.esoxjem.movieguide

import android.app.Activity
import android.app.Application
import com.esoxjem.movieguide.di.AppComponent
import com.esoxjem.movieguide.di.DaggerAppComponent
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

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }
}
