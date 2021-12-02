package com.example.customerlistapp

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.activityViewModels

/**
 * Fragment for viewing the details of a single Customer.
 */
class CustomerFragment : Fragment() {
    private val viewModel: CustomerViewModel by activityViewModels()

    /**
     * The customer who is being viewed.
     */
    private lateinit var customer: Customer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    /**
     * Sets the customer and sets all the textviews' text to the user's corresponding detail.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customer = viewModel.currentCustomer!!

        setOrDefault(view.findViewById(R.id.customerNameTextView), customer.customerName, R.string.customer_name)
        setOrDefault(view.findViewById(R.id.idTextView), customer.id, R.string.id)
        setOrDefault(view.findViewById(R.id.additionalNameTextView), customer.additionalName, R.string.additional_name)
        setOrDefault(view.findViewById(R.id.legalNameTextView), customer.legalName, R.string.legal_name)
        setOrDefault(view.findViewById(R.id.phoneNumberTextView), customer.phoneNumber, R.string.phone_number)
        setOrDefault(view.findViewById(R.id.phoneNumberExtensionTextView), customer.phoneNumberExtension, R.string.phone_number_extension)
        setOrDefault(view.findViewById(R.id.purchaseOrderRequiredTextView), customer.purchaseOrderRequired.toString(), R.string.purchase_order_required)
        setOrDefault(view.findViewById(R.id.taxCategoryTextView), customer.taxCategory, R.string.tax_category)
        setOrDefault(view.findViewById(R.id.emailAddressTextView), customer.emailAddress, R.string.email_address)
        setOrDefault(view.findViewById(R.id.companyCodeIdTextView), customer.companyCodeId, R.string.company_code_id)
        setOrDefault(view.findViewById(R.id.subRouteTextView), customer.subRoute, R.string.sub_route)
        setOrDefault(view.findViewById(R.id.deliveryDelayTextView), customer.deliveryDelay, R.string.delivery_delay)
        setOrDefault(view.findViewById(R.id.currencyTextView), customer.currency, R.string.currency)
    }

    /**
     * Sets textView's text to the string resource with ID stringRes, with value formatted in.
     *
     * If the value is null, then it is replaced with None.
     */
    private fun setOrDefault(textView: TextView, value: String?, stringRes: Int) {
        if (value != null) {
            textView.text = getString(stringRes, value)
        } else {
            textView.text = getString(stringRes, getString(R.string.none))
        }
    }
}