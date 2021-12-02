package com.example.customerlistapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException

/**
 * ViewModel for Customers.
 */
class CustomerViewModel(application: Application): AndroidViewModel(application) {
    // Use Moshi to parse the JSON file and set _customers to it.
    private val moshi: Moshi = Moshi.Builder().build()
    private val customersJSON = application.assets.open("CustomerData.json")
        .bufferedReader().use { it.readText() }
    val listType = Types.newParameterizedType(List::class.java, Customer::class.java)
    val adapter: JsonAdapter<MutableList<Customer>> = moshi.adapter(listType)
    val _customers = MutableLiveData<MutableList<Customer>>(adapter.fromJson(customersJSON))

    // Read only version (useful for live data)
    val customers: LiveData<MutableList<Customer>>
        get() = _customers

    // The current customer being viewed in CustomerFragment. Set in MainFragment.
    var currentCustomer: Customer? = null
}


