package com.laggerlimited.shoestore.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.laggerlimited.shoestore.R
import com.laggerlimited.shoestore.databinding.FragmentLoginBinding

/**
 * The LoginFragment class uses DataBindingUtil to inflate the layout and contains a view model to
 * retain user input on rotations, pauses, and other lifecycle changes which can be implemented later.
 * Includes an on click listener to navigate to the WelcomeFragment.
 */
class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        // Get reference to the ViewModel
        viewModel =  ViewModelProvider(this).get(LoginViewModel::class.java)

        // Login button on click listener navigates to the WelcomeFragment
        binding.loginButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )
        return binding.root
    }
}