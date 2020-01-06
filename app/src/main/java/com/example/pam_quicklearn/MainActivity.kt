package com.example.pam_quicklearn

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var odblokowane_lekcje = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Świat kultury"
        actionBar.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(applicationContext, R.color.seance)))

    }

    fun onClickLekcja1 ( view: View){
        val intent = Intent(this, Lekcja_act_frag::class.java)
        intent.putExtra("ODBLOKOWANE", odblokowane_lekcje)
        intent.putExtra("AKTUALNA", 1)
        startActivityForResult(intent,1)
    }

    fun onClickLekcja2 ( view: View){
        if(odblokowane_lekcje>1) {
            val intent = Intent(this, Lekcja_act_frag::class.java)
            intent.putExtra("ODBLOKOWANE", odblokowane_lekcje)
            intent.putExtra("AKTUALNA", 2)
            startActivityForResult(intent, 1)
        }
        else{
            Toast.makeText(this,getString(R.string.main_toast_odblokuj), Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickLekcja3 ( view: View){
        if(odblokowane_lekcje>2) {
            val intent = Intent(this, Lekcja_act_frag::class.java)
            intent.putExtra("ODBLOKOWANE", odblokowane_lekcje)
            intent.putExtra("AKTUALNA", 3)
            startActivityForResult(intent, 1)
        }
        else{
            Toast.makeText(this,getString(R.string.main_toast_odblokuj), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode==1 && resultCode == Activity.RESULT_OK){
            //odblokowane_lekcje =  if (odblokowane_lekcje + 1 > 3) 3 else (odblokowane_lekcje + 1)
            odblokowane_lekcje = data!!.getIntExtra("ODBLOKOWANE", 1)
            Log.d("POWROT MAIN", "OK")
        }
        if(odblokowane_lekcje > 1){
            lekcja2.setBackgroundColor(resources.getColor(R.color.seance))
            if(odblokowane_lekcje > 2){
                lekcja3.setBackgroundColor(resources.getColor(R.color.seance))
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
