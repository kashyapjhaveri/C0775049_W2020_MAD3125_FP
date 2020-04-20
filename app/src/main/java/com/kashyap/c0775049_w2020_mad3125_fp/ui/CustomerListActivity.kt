package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.adapters.CustomerListAdapter
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Internet
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Mobile
import com.kashyap.c0775049_w2020_mad3125_fp.models.customer.Customer
import kotlinx.android.synthetic.main.activity_customer_list.*
import kotlinx.android.synthetic.main.activity_login.*

class CustomerListActivity : AppCompatActivity() {

    fun fillData(){
        val linerLayoutManager = LinearLayoutManager(this@CustomerListActivity)
        rvCustomerList.layoutManager = linerLayoutManager
        rvCustomerList.adapter = CustomerListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_list)

        val tempObj = Customer("1","Kashyap","Jhaveri","a@a.com")

        tempObj.addBill(Mobile("1","Apr 18, 2020","Google","Medium",4.0,100.0))

        DataRepo.addCustomer(tempObj)


        fillData()
    }

    override fun onRestart() {
        super.onRestart()
        fillData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_customer_list,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_add_customer -> {
                val intent = Intent(this@CustomerListActivity, AddNewCustomerActivity::class.java)
                startActivity(intent)
            }

            R.id.mnu_logout -> {
                val intent = Intent(this@CustomerListActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
