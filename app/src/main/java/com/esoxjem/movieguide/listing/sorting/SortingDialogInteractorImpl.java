package com.esoxjem.movieguide.listing.sorting;

/**
 * @author arun
 */
public class SortingDialogInteractorImpl implements SortingDialogInteractor {
    private SortingOptionStore sortingOptionStore;

    public SortingDialogInteractorImpl(SortingOptionStore store) {
        sortingOptionStore = store;
    }

    @Override
    public int getSelectedSortingOption() {
        return sortingOptionStore.getSelectedOption();
    }

    @Override
    public void setSortingOption(SortType sortType) {
        sortingOptionStore.setSelectedOption(sortType);
    }
}
