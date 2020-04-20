package com.kashyap.c0775049_w2020_mad3125_fp.models.bill

class Hydro(id: String, billDate: String, agencyName : String, unitCosumed : Double) :
    Bill(id, billDate, "Hydro", unitCosumed * 10) {

    var agencyName : String = agencyName
    var unitCosumed : Double = unitCosumed
}