package com.kashyap.c0775049_w2020_mad3125_fp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kashyap.c0775049_w2020_mad3125_fp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val background = Thread {
            Thread.sleep(3000)

            var intent :Intent = Intent(baseContext,LoginActivity::class.java)

            startActivity(intent)
            finish()
        }

        background.start()
    }
}
