package com.esoxjem.movieguide.di.modules;

import com.esoxjem.movieguide.listing.sorting.SortingDialogInteractor;
import com.esoxjem.movieguide.listing.sorting.SortingDialogInteractorImpl;
import com.esoxjem.movieguide.listing.sorting.SortingDialogPresenter;
import com.esoxjem.movieguide.listing.sorting.SortingDialogPresenterImpl;
import com.esoxjem.movieguide.listing.sorting.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class SortingModule {
    @Provides
    public SortingDialogInteractor providesSortingDialogInteractor(SortingOptionStore store) {
        return new SortingDialogInteractorImpl(store);
    }

    @Provides
    public SortingDialogPresenter providePresenter(SortingDialogInteractor interactor) {
        return new SortingDialogPresenterImpl(interactor);
    }
}
