package com.laggerlimited.shoestore.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.laggerlimited.shoestore.R
import com.laggerlimited.shoestore.databinding.FragmentShoeListBinding
import com.laggerlimited.shoestore.databinding.ShoeObjectBinding
import com.laggerlimited.shoestore.models.ShoeListViewModel


/**
 * The ShoeListFragment class uses DataBindingUtil to inflate the layout and includes an on click
 * listener attached to a floating action button (FAB) that navigates to the DetailsFragment.
 *
 * A view model observer is listening for changes in the shoe list. A change occurs when the user
 * uses the DetailsFragment to add a new Shoe object to the list. When the view model observer sees
 * a change it inflates a new layout object that contains the new shoe's data.
 *
 * A logout menu is utilized to allow the user to navigate back to the login screen.
 */
class ShoeListFragment : Fragment() {
    // Reference the view model by using by activityViewModels(), the Kotlin property delegate
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        // Attach this ShoeListFragment as the lifecycle owner so LiveData can be observed
        binding.lifecycleOwner = this

        // View model observer listens for changes in the shoeList
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            // Loop for each shoe object in the shoeList that is added using the DetailsFragment
            for (shoe in it) {
                // Inflate each linear layout(shoe_object) inside the linear layout(shoeListLayout)
                DataBindingUtil.inflate<ShoeObjectBinding>(
                    layoutInflater,
                    R.layout.shoe_object,
                    binding.shoeListLayout,
                    true
                ).apply{this.shoe = shoe}
            }
        })
        // Details FAB on click listener navigates to the DetailsFragment
        binding.detailsFAB.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_detailsFragment)
        )
        // Set this fragment to have a menu
        setHasOptionsMenu(true)
        return binding.root
    }
    // Override function called when the menu is created in the ShoeListFragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // Inflate the menu defined in the menu.xml
        inflater.inflate(R.menu.menu, menu)
    }
    // Override function called when the logout item is selected by the user in the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Check if the menu item selected is the logout item
        if(item.itemId == R.id.LogoutItem) {
            // If the menu item id is LogoutItem then navigate back to the LoginFragment
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}