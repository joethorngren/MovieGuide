package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.BaseApplication
import com.esoxjem.movieguide.di.modules.AppModule
import com.esoxjem.movieguide.di.modules.DetailsModule
import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.NetworkModule
import com.esoxjem.movieguide.favorites.FavoritesModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class, FavoritesModule::class, ActivityBuilder::class])
interface AppComponent {
    fun plus(detailsModule: DetailsModule): DetailsComponent

    fun plus(listingModule: ListingModule): ListingComponent

//    @Component.Builder
//    interface Builder {
//        @BindsInstance fun application(application: Application): Builder
//        fun build(): AppComponent
//    }

    fun inject(application: BaseApplication)
}
