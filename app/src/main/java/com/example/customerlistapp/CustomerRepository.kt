package com.example.customerlistapp

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CustomerRepository(private val customerDao: CustomerDao) {
    val customers: Flow<List<Customer>> = customerDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(customer: Customer) {
        customerDao.insert(customer)
    }
}