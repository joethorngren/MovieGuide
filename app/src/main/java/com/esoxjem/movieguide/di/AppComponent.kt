package com.esoxjem.movieguide.di

import android.app.Application
import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder

    }
}
