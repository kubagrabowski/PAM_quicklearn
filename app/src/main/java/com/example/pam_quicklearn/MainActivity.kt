package com.example.pam_quicklearn

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Świat kultury"
        actionBar!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(applicationContext, R.color.seance)))

    }
}
