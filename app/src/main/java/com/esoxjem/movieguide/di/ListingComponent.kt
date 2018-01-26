package com.esoxjem.movieguide.di

import com.esoxjem.movieguide.di.modules.ListingModule
import com.esoxjem.movieguide.di.modules.SortingModule
import com.esoxjem.movieguide.listing.MoviesListingActivity
import com.esoxjem.movieguide.listing.MoviesListingFragment
import com.esoxjem.movieguide.listing.sorting.SortingDialogFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author arunsasidharan
 */
@Subcomponent(modules = arrayOf(ListingModule::class, SortingModule::class))
interface ListingComponent {

    fun inject(fragment: MoviesListingFragment): MoviesListingFragment

    fun inject(fragment: SortingDialogFragment): SortingDialogFragment

}
