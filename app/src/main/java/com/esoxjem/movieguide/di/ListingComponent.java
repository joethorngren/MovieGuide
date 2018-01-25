package com.esoxjem.movieguide.di;

import com.esoxjem.movieguide.di.modules.ListingModule;
import com.esoxjem.movieguide.di.scopes.ListingScope;
import com.esoxjem.movieguide.listing.MoviesListingFragment;
import com.esoxjem.movieguide.listing.sorting.SortingDialogFragment;
import com.esoxjem.movieguide.di.modules.SortingModule;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
