package com.example.pam_quicklearn

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_test1.*

class Test_act_frag : AppCompatActivity() {


    val state = PlayerState()

    var fragT1 : Fragment? = null
    var fragT2 : Fragment? = null
    var fragT3 : Fragment? = null

    var next = 1
    var wynik = 0

    var odpowiedzTest1 = 0
    var odpowiedzTest2 = 0
    var odpowiedzTest3 = 0

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

        transakcja.add(R.id.fragment_test, fragT1!!)

        transakcja.commit()

    }

    fun do1Test(view: View){

        when(wynik){
            0 ->{
                odpowiedzTest3 = (fragT3 as Fragment_test3).test3ogarMojWybor()

                when(odpowiedzTest3){
                    -1 -> Toast.makeText(this, "Zaznacz tylko jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    0 -> Toast.makeText(this, "Zaznacz najpierw jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    else -> {
                        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
                        transakcja.replace(R.id.fragment_test, fragT1!!)
                        transakcja.commit()
                        wynik++

                    }
                }

            }
            1 ->{
                onBackPressed()
            }
        }





    }

    fun do2Test(view: View){
        when(wynik){
            0 ->{
                odpowiedzTest1 = (fragT1 as Fragment_test1).test1ogarMojWybor()

                when(odpowiedzTest1){
                    -1 -> Toast.makeText(this, "Zaznacz tylko jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    0 -> Toast.makeText(this, "Zaznacz najpierw jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    else -> {
                        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
                        transakcja.replace(R.id.fragment_test, fragT2!!)
                        transakcja.commit()
                    }
                }
            }
            else -> {
                val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
                transakcja.replace(R.id.fragment_test, fragT2!!)
                transakcja.commit()

            }
        }



    }

    fun do3Test(view: View){

        when(wynik){
            0 ->{
                odpowiedzTest2 = (fragT2 as Fragment_test2).test2ogarMojWybor()

                when(odpowiedzTest2){
                    -1 -> Toast.makeText(this, "Zaznacz tylko jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    0 -> Toast.makeText(this, "Zaznacz najpierw jedną odpowiedź", Toast.LENGTH_SHORT).show()
                    else -> {
                        val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()
                        transakcja.replace(R.id.fragment_test, fragT3!!)
                        transakcja.commit()
                    }
                }

            }
            else -> {
                val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()
                transakcja.replace(R.id.fragment_test, fragT3!!)
                transakcja.commit()

            }

        }




    }
}
