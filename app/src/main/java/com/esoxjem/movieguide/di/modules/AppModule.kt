package com.esoxjem.movieguide.di.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.esoxjem.movieguide.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: BaseApplication): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideResources(context: Context): Resources {
        return context.resources
    }
}
