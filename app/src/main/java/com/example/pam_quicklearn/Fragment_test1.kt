package com.example.pam_quicklearn


import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test1.*

class Fragment_test1: Fragment() {

    var wynik = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view: View = inflater.inflate(R.layout.fragment_test1, container, false)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val napis = getString(R.string.frag1_hamiltontext) + "\n\n" + getString(R.string.frag1_hansentext) + "\n\n" + getString(R.string.frag1_heatherstext)
    }



    fun test1ogarMojWybor() : Int{
        if( (test1_check1.isChecked && test1_check2.isChecked) || (test1_check3.isChecked && test1_check2.isChecked) || (test1_check1.isChecked && test1_check3.isChecked)){
            wynik = -1
            return -1
        }
        else if(test1_check1.isChecked){
            wynik = 1
            return 1

        }
        else if(test1_check2.isChecked){
            wynik = 2
            return 2
        }
        else if(test1_check3.isChecked){
            wynik = 3
            return 3
        }
        else return 0
    }

    fun test1Odpowiedzi(wybor:Int){

        when(wybor){
            0 -> null
            1 -> test1_check1.setTextColor(resources.getColor(R.color.rej))
            2 -> test1_check2.setTextColor(resources.getColor(R.color.rej))
            3 -> test1_check3.setTextColor(resources.getColor(R.color.rej))
        }
        if(wynik != 0) test1_check1.setTextColor(resources.getColor(R.color.akc))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test1Odpowiedzi(wynik)
    }
}