package com.kashyap.c0775049_w2020_mad3125_fp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import kotlinx.android.synthetic.main.activity_show_bill_details.*

class ShowBillDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_bill_details)

        val seletedCustomer = DataRepo.getCustomer(intent.getIntExtra("selectedCustomer",0))

        editTextId.setText(seletedCustomer.id)
        editTextFullName.setText(seletedCustomer.fullName)
        editTextEmail.setText(seletedCustomer.emailId)


    }
}
