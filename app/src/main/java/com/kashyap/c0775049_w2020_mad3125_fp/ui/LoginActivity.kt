package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kashyap.c0775049_w2020_mad3125_fp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //ButterKnife.inject(this)

        Toast.makeText(this,editTextEmail.text,Toast.LENGTH_LONG).show()
    }
}
