package com.kashyap.c0775049_w2020_mad3125_fp.models.bill

class Internet(id: String, billDate: String, providerString : String, gbUsed : Double) :
    Bill(id, billDate, "Internet", gbUsed * 5) {

    var providerName : String = providerString
    var gbUsed : Double = gbUsed

}