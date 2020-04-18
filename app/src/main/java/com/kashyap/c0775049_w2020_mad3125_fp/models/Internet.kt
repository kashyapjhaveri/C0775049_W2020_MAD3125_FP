package com.kashyap.c0775049_w2020_mad3125_fp.models

class Internet(id: Int, billDate: String, billType: String, totalAmount: Float, providerString : String, gbUsed : Float) :
    Bill(id, billDate, billType, totalAmount) {

    var providerName : String = providerString
    var gbUsed : Float = gbUsed


}