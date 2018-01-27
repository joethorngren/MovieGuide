package com.esoxjem.movieguide.di;

import com.esoxjem.movieguide.di.modules.DetailsModule;
import com.esoxjem.movieguide.di.modules.AppModule;
import com.esoxjem.movieguide.di.modules.ListingModule;
import com.esoxjem.movieguide.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
