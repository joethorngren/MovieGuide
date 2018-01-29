package com.esoxjem.movieguide.util

import android.content.Context
import android.widget.Toast
import javax.inject.Inject


class Toaster @Inject constructor(val context: Context) {

    fun makeToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}