package com.kashyap.c0775049_w2020_mad3125_fp.models.customer

import com.kashyap.c0775049_w2020_mad3125_fp.models.Bill
import java.text.NumberFormat

class Customer(id : String, firstName : String, lastName : String, emailId : String) {

    var id : String = id
    var firstName : String = firstName
    var lastName : String = lastName
    val fullName : String
        get() {
            return "$firstName $lastName";
        }
    var emailId : String = emailId
    private var totalAmount : Double = 0.0

    val totalFormattedAmount : String
        get(){
           return NumberFormat.getInstance().format(this.totalAmount)
        }


    lateinit var bills : HashMap<String,Bill>


}