package com.example.customerlistapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel for Customers.
 */
class CustomerViewModel(private val customerRepository: CustomerRepository): ViewModel() {
    // Use Moshi to parse the JSON file and set _customers to it.
//    private val moshi: Moshi = Moshi.Builder().build()
//    private val customersJSON = application.assets.open("CustomerData.json")
//        .bufferedReader().use { it.readText() }
//    val listType = Types.newParameterizedType(List::class.java, Customer::class.java)
//    val adapter: JsonAdapter<MutableList<Customer>> = moshi.adapter(listType)
//    val _customers = MutableLiveData<MutableList<Customer>>(adapter.fromJson(customersJSON))

    val customers: LiveData<List<Customer>> = customerRepository.customers.asLiveData()

    fun addCustomer(customer: Customer) = viewModelScope.launch {
        customerRepository.insert(customer)
    }

    // The current customer being viewed in CustomerFragment. Set in MainFragment.
    var currentCustomer: Customer? = null
}

class CustomerViewModelFactory(private val repository: CustomerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CustomerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

