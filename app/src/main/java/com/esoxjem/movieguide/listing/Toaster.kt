package com.esoxjem.movieguide.listing

import android.widget.Toast
import com.esoxjem.movieguide.details.MovieDetailsActivity
import javax.inject.Inject


//class Toaster @Inject constructor(val detailsActivity: MovieDetailsActivity) {
class Toaster(val detailsActivity: MovieDetailsActivity) {

    fun makeToast() {
        Toast.makeText(detailsActivity, "Hello!", Toast.LENGTH_LONG).show()
    }
}