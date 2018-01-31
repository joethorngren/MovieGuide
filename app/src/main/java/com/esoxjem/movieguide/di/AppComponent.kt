package com.esoxjem.movieguide.di


import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.ActivityBindingModule
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.FragmentBindingModule
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
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }
}