package com.example.customerlistapp

import android.app.Application

class CustomerListApplication : Application() {
    val database by lazy { CustomerDatabase.getDatabase(this) }
    val repository by lazy { CustomerRepository(database.customerDao()) }
}