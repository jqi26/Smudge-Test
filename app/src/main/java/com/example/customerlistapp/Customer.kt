package com.example.customerlistapp

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Class representing a Customer
 */
@JsonClass(generateAdapter = true)
class Customer (
    @Json(name = "AdditionalName") val additionalName: String?,
    val id: String,
    @Json(name = "CustomerName") val customerName: String,
    @Json(name = "LegalName") val legalName: String?,
    @Json(name = "PhoneNumber") val phoneNumber: String?,
    @Json(name = "PhoneNumberExtension") val phoneNumberExtension: String?,
    @Json(name = "PurchaseOrderRequired") val purchaseOrderRequired: Boolean,
    @Json(name = "TaxCategory") val taxCategory: String?,
    @Json(name = "EmailAddress") val emailAddress: String?,
    @Json(name = "CompanyCodeId") val companyCodeId: String?,
    @Json(name = "SubRoute") val subRoute: String?,
    @Json(name = "DeliveryDelay") val deliveryDelay: String?,
    @Json(name = "Currency") val currency: String?,
    )
{
    override fun toString(): String {
        return "$customerName ($id)"
    }
}