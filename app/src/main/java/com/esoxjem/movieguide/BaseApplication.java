package com.esoxjem.movieguide;

import android.app.Application;

import com.esoxjem.movieguide.di.DaggerAppComponent;
import com.esoxjem.movieguide.di.DetailsComponent;
import com.esoxjem.movieguide.di.modules.DetailsModule;
import com.esoxjem.movieguide.di.AppComponent;
import com.esoxjem.movieguide.di.modules.AppModule;
import com.esoxjem.movieguide.di.ListingComponent;
import com.esoxjem.movieguide.di.modules.ListingModule;
import com.esoxjem.movieguide.di.modules.NetworkModule;

/**
 * @author arun
 */
public class BaseApplication extends Application {
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public DetailsComponent createDetailsComponent() {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent() {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent() {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent() {
        listingComponent = null;
    }

    public ListingComponent getListingComponent() {
        return listingComponent;
    }
}
