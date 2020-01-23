package com.example.pam_quicklearn

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.WebViewFragment
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class Lekcja_act_frag : AppCompatActivity() {

    var odblok = 1
    var aktualna = 1

    var fragL1: Fragment? = null
    var fragL2: Fragment? = null
    var fragL3: Fragment? = null

    val state = PlayerState()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lekcja_act_frag)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)




        val actionBar = supportActionBar

        actionBar!!.run{
            title = "Lekcje"
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(applicationContext,R.color.seance)))
        }

        odblok = intent.getIntExtra("ODBLOKOWANE", 1)
        aktualna = intent.getIntExtra("AKTUALNA", 1)

        fragL1 = Fragment_lekcja1()
        fragL2 = Fragment_lekcja2(this, state)
        fragL3= Fragment_lekcja3(this, state)

        val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()

        if(aktualna == 1)  transakcja.add(R.id.fragment_lekcja, fragL1!!)
        if(aktualna == 2)  transakcja.add(R.id.fragment_lekcja, fragL2!!)
        if(aktualna == 3)  transakcja.add(R.id.fragment_lekcja, fragL3!!)

        transakcja.commit()

    }

    override fun onSupportNavigateUp(): Boolean {
        //intent.extras.clear()

        //odblok = if (odblok == 3 ) 3 else aktualna+1
        intent.putExtra("ODBLOKOWANE", odblok)

        setResult(Activity.RESULT_OK,intent)
        finish()

        //onBackPressed()
        return true
    }

    fun startTestow(view:View){
        val intent = Intent(this, Test_act_frag::class.java)
        startActivity(intent)
    }

    fun do1Lekcji(view:View){
        aktualna = 1
        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
        transakcja.replace(R.id.fragment_lekcja, fragL1!!)
        transakcja.commit()
    }

    fun do2Lekcji(view:View){
        if(odblok>=2){
            frag2setHamilton(view)
        }
        aktualna = 2
        odblok = if (odblok ==3 ) 3 else 2
        val transakcja:FragmentTransaction = supportFragmentManager.beginTransaction()
        transakcja.replace(R.id.fragment_lekcja, fragL2!!)
        transakcja.commit()


    }

    fun do3Lekcji(view:View){
        if(odblok>=3){
            frag3setHamilton(view)
        }
        if(odblok == 1)
        {
            Toast.makeText(this, getString(R.string.main_toast_odblokuj), Toast.LENGTH_SHORT).show()
        }
        else
        {
            aktualna = 3
            odblok = 3
            val transakcja: FragmentTransaction = supportFragmentManager.beginTransaction()
            transakcja.replace(R.id.fragment_lekcja, fragL3!!)
            transakcja.commit()

        }
    }

    fun frag2setHamilton(view:View){
        (fragL2 as Fragment_lekcja2).setHamilton()
    }

    fun frag2setHansen(view:View){
        //fragL2!!.onStop()
        //state.source = SourceType.local_video
        //state.whenReady = false
        //state.position = 0
        //state.window = 0
        //state.uristringAudio =  "assets:///Hansen.mp3"

        //val fragment:Fragment_lekcja2 = supportFragmentManager.findFragmentById(R.id.fragment_lekcja) as Fragment_lekcja2
        //fragment.cos()

        (fragL2 as Fragment_lekcja2).setHansen()

        //fragL2!!.onStart()
    }

    fun frag2setHeathers(view:View){
        (fragL2 as Fragment_lekcja2).setHeathers()
    }


    fun frag3setHamilton(view:View){
        (fragL3 as Fragment_lekcja3).setHamilton()
    }

    fun frag3setHansen(view:View){

        (fragL3 as Fragment_lekcja3).setHansen()

    }


}
