package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup
import com.google.android.material.datepicker.MaterialDatePicker
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Hydro
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Internet
import com.kashyap.c0775049_w2020_mad3125_fp.models.bill.Mobile
import kotlinx.android.synthetic.main.activity_add_new_bill.*
import kotlinx.android.synthetic.main.fragment_hydro.*
import kotlinx.android.synthetic.main.fragment_internet.*
import kotlinx.android.synthetic.main.fragment_internet.editTextInternetGbUsed
import kotlinx.android.synthetic.main.fragment_mobile.*

class AddNewBillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_bill)


        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,InternetFragment()).commit()

        editTextBillDate.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                val builder = MaterialDatePicker.Builder.datePicker()
                val picker = builder.build()

                picker.show(supportFragmentManager, picker.toString())

                picker.addOnPositiveButtonClickListener {
                    editTextBillDate.setText(picker.headerText)
                }
            }
        }

        cgBillType.setOnCheckedChangeListener(ChipGroup.OnCheckedChangeListener { group, checkedId ->
            val manager = supportFragmentManager;
            val trans = manager.beginTransaction()

            when (checkedId){
                R.id.chipInternet -> {
                    trans.replace(R.id.fragment_container, InternetFragment())
                }

                R.id.chipHydro -> {
                    trans.replace(R.id.fragment_container,HydroFragment());
                }

                R.id.chipMobile -> {
                    trans.replace(R.id.fragment_container,MobileFragment())
                }
            }
            trans.commit();
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_new_bill,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnu_add_new_bill){

            if (editTextId.text.toString().isEmpty()){
                editTextId.error = "Bill ID cannot be empty"
            }
            else if (editTextBillDate.text.toString().isEmpty()){
                editTextBillDate.error = "Bill Date cannot be empty"
            }
            else {
                when (cgBillType.checkedChipId){
                    R.id.chipInternet -> {
                        if (editTextProviderName.text.toString().isEmpty()){
                            editTextProviderName.error = "Provider name cannot be empty"
                        }
                        else if (editTextInternetGbUsed.text.toString().isEmpty()){
                            editTextInternetGbUsed.error = "Gb used cannot be empty"
                        }
                        else{
                            val customer = DataRepo.getCustomer(intent.getIntExtra("selectedCustomer",0));

                            customer.addBill(Internet(editTextId.text.toString(),editTextBillDate.text.toString(),editTextProviderName.text.toString(),editTextInternetGbUsed.text.toString().toDouble()))
                            finish()
                        }
                    }

                    R.id.chipHydro -> {
                        if (editTextAgencyName.text.toString().isEmpty()){
                            editTextAgencyName.error = "Agency name cannot be empty"
                        }
                        else if (editTextUnitConsumed.text.toString().isEmpty()){
                            editTextUnitConsumed.error = "Unit consumed cannot be empty"
                        }
                        else{
                            val customer = DataRepo.getCustomer(intent.getIntExtra("selectedCustomer",0));
                            customer.addBill(Hydro(editTextId.text.toString(),editTextBillDate.text.toString(),editTextAgencyName.text.toString(),editTextUnitConsumed.text.toString().toDouble()))
                            finish()
                        }
                    }

                    R.id.chipMobile -> {
                        if (editTextManufacturerName.text.toString().isEmpty()){
                            editTextManufacturerName.error = "Manufacturer name cannot be empty";
                        }
                        else if (editTextPlanName.text.toString().isEmpty()){
                            editTextPlanName.error = "Plan name cannot be empty";
                        }
                        else if (editTextMobileGbUsed.text.toString().isEmpty()){
                            editTextMobileGbUsed.error = "Gb used cannot be empty"
                        }
                        else if (editTextMinutesUsed.text.toString().isEmpty()){
                            editTextMinutesUsed.error = "Minutes used cannot be empty"
                        }
                        else{
                            val customer = DataRepo.getCustomer(intent.getIntExtra("selectedCustomer",0));
                            customer.addBill(Mobile(editTextId.text.toString(),editTextBillDate.text.toString(),editTextManufacturerName.text.toString(),editTextPlanName.text.toString(),editTextMobileGbUsed.text.toString().toDouble(),editTextMinutesUsed.text.toString().toDouble()))
                            finish()
                        }
                    }
                }
            }

        }
        return super.onOptionsItemSelected(item)

    }
}
