package com.laggerlimited.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

/**
 * The ShoeListViewModel implements the ViewModel class to help prepare data for the UI.
 * MutableLiveData is used to observe an ArrayList of Shoe objects. LiveData encapsulation is used
 * where _shoeList is for internal modification, and shoeList is for external use.
 * The onButtonClick listener looks for a change in the shoeList and adds the new Shoe object
 * when there is one. The button click also navigates back to the last fragment on the back stack.
 */
class ShoeListViewModel: ViewModel()     {

    // Create LiveData object and initialize it
    private var _shoeList = MutableLiveData<ArrayList<Shoe>>()
    // Use a backing property to override the getter call
    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList
    // Initialize shoeList with an empty ArrayList
    init {
        _shoeList.value = ArrayList()
    }
    // OnButtonClick listener takes the View and Shoe objects as params and adds a new Shoe item
    // to the shoeList when there is one. It also navigates up one on the back stack
    fun onButtonClick(v: View, shoe: Shoe) {
        _shoeList.value?.add(shoe)
        navBack(v)
    }
    // This function is used to navigate back to the last fragment on the back stack
    fun navBack(v: View){
        v.findNavController().navigateUp()
    }
}
