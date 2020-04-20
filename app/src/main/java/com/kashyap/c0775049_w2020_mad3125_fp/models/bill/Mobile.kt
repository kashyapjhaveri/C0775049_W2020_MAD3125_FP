package com.kashyap.c0775049_w2020_mad3125_fp.models.bill

class Mobile(id: String, billDate: String, manufacturerName: String, planName:String, gbUsed:Double, minuteUsed:Double) :
    Bill (id, billDate, "Mobile", ((minuteUsed * 1)+(gbUsed * 3))){

    var manufacturerName : String = manufacturerName
    var planName : String = planName
    var gbUsed : Double = gbUsed
    var minuteUsed : Double = minuteUsed

}