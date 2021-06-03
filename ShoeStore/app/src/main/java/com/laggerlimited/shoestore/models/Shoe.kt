package com.laggerlimited.shoestore.models

import androidx.databinding.BaseObservable

/**
 * The Shoe model defines a Shoe object and implements the BaseObservable class, this makes this
 * class observable by other classes so they can react to any change in this observable class.
 */
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : BaseObservable()