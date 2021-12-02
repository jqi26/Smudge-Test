package com.example.customerlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the Customer Recycler View.
 */
class CustomerAdapter(private var customers: List<Customer>, private val onCustomerHandler: OnCustomerHandler) :
    RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    /**
     * ViewHolder for a single Customer.
     */
    class ViewHolder(view: View, val onCustomerHandler: OnCustomerHandler) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val customerItemNameTextView: TextView

        init {
            customerItemNameTextView = view.findViewById(R.id.customerItemNameTextView)
            view.setOnClickListener(this)
        }

        /**
         * Handler for when a customer is clicked. Calls the function implemented by onCustomerHandler
         */
        override fun onClick(p0: View?) {
            onCustomerHandler.onCustomerClick(adapterPosition)
        }
    }

    /**
     * Creates a new ViewHolder using the customer_item layout.
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.customer_item, viewGroup, false)

        return ViewHolder(view, onCustomerHandler)
    }

    /**
     * Binds the viewHolder by setting the viewHolder's content.
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.customerItemNameTextView.text = customers[position].toString()
    }

    override fun getItemCount() = customers.size

    /**
     * Updates the customers list for live data.
     */
    fun setData(customers: List<Customer>) {
        this.customers = customers
        notifyDataSetChanged()
    }

    /**
     * Interface for handling different clicks on this Adapter.
     */
    interface OnCustomerHandler {
        /**
         * Handler for when a Customer item is clicked.
         */
        fun onCustomerClick(position: Int)
    }
}
