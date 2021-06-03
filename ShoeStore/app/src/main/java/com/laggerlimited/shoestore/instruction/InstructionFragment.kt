package com.laggerlimited.shoestore.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.laggerlimited.shoestore.R
import com.laggerlimited.shoestore.databinding.FragmentInstructionBinding

/**
 * The InstructionFragment class uses DataBindingUtil to inflate the layout and contains an on
 * click listener used to navigate to the ShoeListFragment.
 */
class InstructionFragment : Fragment() {
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )
        binding.shoeListButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoeListFragment)
        )
        return binding.root
    }
}