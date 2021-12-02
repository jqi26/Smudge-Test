package com.example.customerlistapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Class representing a Customer
 */
@JsonClass(generateAdapter = true)
@Entity(tableName = "CUSTOMER")
class Customer (
    @Json(name = "AdditionalName")
    @ColumnInfo
    val additionalName: String?,

    @PrimaryKey
    val id: String,

    @ColumnInfo
    @Json(name = "CustomerName")
    val customerName: String,

    @ColumnInfo
    @Json(name = "LegalName")
    val legalName: String?,

    @Json(name = "PhoneNumber")
    val phoneNumber: String?,

    @ColumnInfo
    @Json(name = "PhoneNumberExtension")
    val phoneNumberExtension: String?,

    @ColumnInfo
    @Json(name = "PurchaseOrderRequired")
    val purchaseOrderRequired: Boolean,

    @ColumnInfo
    @Json(name = "TaxCategory")
    val taxCategory: String?,

    @ColumnInfo
    @Json(name = "EmailAddress")
    val emailAddress: String?,

    @ColumnInfo
    @Json(name = "CompanyCodeId")
    val companyCodeId: String?,

    @ColumnInfo
    @Json(name = "SubRoute")
    val subRoute: String?,

    @ColumnInfo
    @Json(name = "DeliveryDelay")
    val deliveryDelay: String?,

    @ColumnInfo
    @Json(name = "Currency")
    val currency: String?

    ) {
    override fun toString(): String {
        return "$customerName ($id)"
    }
}