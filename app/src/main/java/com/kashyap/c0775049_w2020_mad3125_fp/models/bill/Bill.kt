package com.kashyap.c0775049_w2020_mad3125_fp.models.bill

import java.text.NumberFormat

open class Bill(id : String, billDate : String, billType : String, totalAmount : Double) {

    var id : String = id
    var billDate : String = billDate
    var billType : String = billType
    var totalAmount : Double = totalAmount

    val totalFormattedAmount : String
        get(){
            return NumberFormat.getCurrencyInstance().format(totalAmount)
        }

}