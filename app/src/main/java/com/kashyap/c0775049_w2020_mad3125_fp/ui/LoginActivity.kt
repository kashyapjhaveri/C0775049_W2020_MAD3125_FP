package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kashyap.c0775049_w2020_mad3125_fp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        
        ButtonLogIn.setOnClickListener(View.OnClickListener {

            if (editTextEmail.text.toString().isEmpty()) {
                editTextEmail.error = "Email cannot be empty!"
            }
            else if (editTextPassword.text.toString().isEmpty()) {
                editTextPassword.error = "Password cannot be empty!";
            }
            else if (editTextEmail.text.toString() == "admin@admin.com" && editTextPassword.text.toString() == "admin"){
                val intent = Intent(this@LoginActivity, CustomerListActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Incorrect email or password")
                    .setNeutralButton("Ok") { dialog, which ->
                        // Respond to neutral button press
                    }.show()
            }

        })
        
    }
}
