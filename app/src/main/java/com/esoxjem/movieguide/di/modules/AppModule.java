package com.esoxjem.movieguide.di.modules;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public Resources provideResources(Context context) {
        return context.getResources();
    }
}
