package com.kashyap.c0775049_w2020_mad3125_fp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.kashyap.c0775049_w2020_mad3125_fp.R
import com.kashyap.c0775049_w2020_mad3125_fp.dataRepo.DataRepo
import com.kashyap.c0775049_w2020_mad3125_fp.models.customer.Customer
import kotlinx.android.synthetic.main.activity_add_new_customer.*

class AddNewCustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_customer)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_new_customer,menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.mnu_save)
        {
            if (editTextId.text.toString().isEmpty()){
                editTextId.error = "Customer ID cannot be empty"
            }
            else if (editTextFirstName.text.toString().isEmpty())
            {
                editTextFirstName.error = "First name cannot be empty"
            }
            else if (editTextLastName.text.toString().isEmpty()){
                editTextLastName.error = "Last name cannot be empty"
            }
            else if (editTextEmail.text.toString().isEmpty()){
                editTextEmail.error = "Email cannot be empty"
            }
            else  if (!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextEmail.text).matches()){  //https://stackoverflow.com/questions/1819142/how-should-i-validate-an-e-mail-address
                editTextEmail.error = "Invalid Email"
            }
            else{
                DataRepo.addCustomer(Customer(editTextId.text.toString(),editTextFirstName.text.toString(),editTextLastName.text.toString(),editTextEmail.text.toString()))
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
