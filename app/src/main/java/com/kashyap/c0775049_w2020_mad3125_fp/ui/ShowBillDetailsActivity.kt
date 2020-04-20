package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.adapters.BillListAdapter
import com.kashyap.c0775049_w2020_mad3125_fp.adapters.CustomerListAdapter
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import kotlinx.android.synthetic.main.activity_customer_list.*
import kotlinx.android.synthetic.main.activity_show_bill_details.*

class ShowBillDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_bill_details)

        val seletedCustomer = DataRepo.getCustomer(intent.getIntExtra("selectedCustomer",0))

        editTextId.setText(seletedCustomer.id)
        editTextFullName.setText(seletedCustomer.fullName)
        editTextEmail.setText(seletedCustomer.emailId)

        val linerLayoutManager = LinearLayoutManager(this@ShowBillDetailsActivity)
        rvBillsList.layoutManager = linerLayoutManager
        rvBillsList.adapter = BillListAdapter(seletedCustomer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_show_bill_details, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnu_add_bill){
            val mIntent = Intent(this@ShowBillDetailsActivity, AddNewBillActivity::class.java)
            mIntent.putExtra("selectedCustomer", intent.getIntExtra("selectedCustomer",0))
            startActivity(mIntent)
        }

        return super.onOptionsItemSelected(item)
    }
}
