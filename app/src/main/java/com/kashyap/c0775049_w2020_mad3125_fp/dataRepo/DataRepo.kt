package com.kashyap.c0775049_w2020_mad3125_fp.dataRepo

import com.kashyap.c0775049_w2020_mad3125_fp.models.customer.Customer

object DataRepo {

    private var customers : ArrayList<Customer> = ArrayList()

    fun addCustomer(customer : Customer) {
        customers.add(customer)
    }

    fun getCustomer(position : Int) : Customer{
        return customers[position]
    }

    fun getAllCustomers(): ArrayList<Customer> {
        return customers
    }


}