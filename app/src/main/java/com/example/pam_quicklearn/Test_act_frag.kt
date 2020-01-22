package com.example.pam_quicklearn

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class Test_act_frag : AppCompatActivity() {


    val state = PlayerState()

    var fragT1 : Fragment? = null
    var fragT2 : Fragment? = null
    var fragT3 : Fragment? = null

    var next = 1
    var wynik = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_act_frag)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val actionBar = supportActionBar

        actionBar!!.run{
            title = "Testy"
            setDisplayHomeAsUpEnabled(false)
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(applicationContext,R.color.seance)))
        }

        fragT1 = Fragment_test1()
        fragT2 = Fragment_test2(this, state)
        fragT3 = Fragment_test3(this, state)

        val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()

        if(next == 1)  transakcja.add(R.id.fragment_test, fragT1!!)
        if(next == 2)  transakcja.add(R.id.fragment_test, fragT2!!)
        if(next == 3)  transakcja.add(R.id.fragment_test, fragT3!!)

        next = (next + 1) % 3

        transakcja.commit()

    }

    fun do1Test(view: View){
        next++
        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
        transakcja.add(R.id.fragment_test, fragT1!!)
        transakcja.commit()
    }

    fun do2Test(view: View){
        next++

        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
        transakcja.add(R.id.fragment_test, fragT2!!)
        transakcja.commit()
    }

    fun do3Test(view: View){
            next = 1
            val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()
        transakcja.add(R.id.fragment_test, fragT3!!)
            transakcja.commit()

    }
}
