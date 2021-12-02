package com.example.customerlistapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

/**
 * Fragment listing the Customers using a RecyclerView.
 */
class MainFragment : Fragment(), CustomerAdapter.OnCustomerHandler {
    private val viewModel: CustomerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    /**
     * Sets up the adapter and recycler view.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CustomerAdapter(viewModel.customers.value!!, this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        viewModel.customers.observe(viewLifecycleOwner) { newCustomers ->
            adapter.setData(newCustomers)
        }
    }

    /**
     * Implements onCustomerCLick from OnCustomerHandler.
     *
     * Navigates the user to the detail page (CustomerFragment) of the clicked customer.
     */
    override fun onCustomerClick(position: Int) {
        viewModel.currentCustomer = viewModel.customers.value!![position]
        findNavController().navigate(R.id.action_mainFragment_to_customerFragment)
    }
}