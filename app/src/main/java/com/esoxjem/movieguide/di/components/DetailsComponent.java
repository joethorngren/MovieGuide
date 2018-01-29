package com.esoxjem.movieguide.di.components;

import com.esoxjem.movieguide.details.MovieDetailsFragment;
import com.esoxjem.movieguide.di.modules.DetailsModule;
import com.esoxjem.movieguide.di.scopes.DetailsScope;

import dagger.Subcomponent;

/**
 * @author arunsasidharan
 */
@DetailsScope
@Subcomponent(modules = {DetailsModule.class})
public interface DetailsComponent {

    void inject(MovieDetailsFragment target);
}
