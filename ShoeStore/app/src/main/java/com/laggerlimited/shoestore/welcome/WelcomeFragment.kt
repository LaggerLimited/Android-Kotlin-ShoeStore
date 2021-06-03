package com.laggerlimited.shoestore.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.laggerlimited.shoestore.R
import com.laggerlimited.shoestore.databinding.FragmentWelcomeBinding


/**
 * The WelcomeFragment class uses DataBindingUtil to inflate the layout. It contains an on click
 * listener used to navigate to the InstructionFragment.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_welcome, container,false
        )
        binding.InstructionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionFragment)
        )
        return binding.root
    }
}