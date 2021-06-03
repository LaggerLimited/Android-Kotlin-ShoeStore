package com.laggerlimited.shoestore.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.laggerlimited.shoestore.R
import com.laggerlimited.shoestore.databinding.FragmentDetailsBinding
import com.laggerlimited.shoestore.models.ShoeListViewModel
import com.laggerlimited.shoestore.models.Shoe


/**
 * The DetailsFragment class adds the Shoe object to the view model. It also handles the fragment's
 * Cancel button behavior.
 */
class DetailsFragment : Fragment() {

    // Reference the view model by using by activityViewModels(), the Kotlin property delegate
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )
        // Bind the shoeViewModel from the XML code to the viewModel
        binding.shoeViewModel= viewModel
        // Bind an empty Shoe object to the view model
        binding.shoe = Shoe("",0.0,"","")

        // Cancel button on click listener to navigate back to the shoe list fragment
        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailsFragment_to_shoeListFragment)
        )
        return binding.root
    }
}