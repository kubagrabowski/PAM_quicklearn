package com.example.pam_quicklearn

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test2.*

class Fragment_test2(val con: Context, val state:PlayerState): Fragment() {

    lateinit var playerHolder: PlayerHolder
    var wynik = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_test2, container, false)

        return view
    }

    override fun onStart() {
        playerHolder.start()

        super.onStart()

    }

    override fun onStop() {
        playerHolder.stop()

        super.onStop()

    }

    override fun onDestroy() {
        playerHolder.release()
        super.onDestroy()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playerHolder = PlayerHolder(con, exoplayer_fragmenttest2, state)
        playerHolder.playerState.position = 0
        playerHolder.playerState.window = 0
        playerHolder.playerState.whenReady = false
        playerHolder.playerState.source = SourceType.local_video
        playerHolder.playerState.uristringVideo = "assets:///Hamilton-NonStop.mp4"


        val napis = getString(R.string.hamilton) + "\n\n" + getString(R.string.frag2_hamiltontext) + "\n\n" + getString(R.string.hansen) + "\n\n" + getString(R.string.frag2_hansentext) + "\n\n" + getString(R.string.heathers) + "\n\n" + getString(R.string.frag2_heatherstext)

    }

    fun test2ogarMojWybor() : Int{
        if( (test2_check1.isChecked && test2_check2.isChecked) || (test2_check3.isChecked && test2_check2.isChecked) || (test2_check1.isChecked && test2_check3.isChecked)){
            return -1
        }
        else if(test2_check1.isChecked){
            wynik = 1
            return 1
        }
        else if(test2_check2.isChecked){
            wynik = 2
            return 2
        }
        else if(test2_check3.isChecked){
            wynik = 3
            return 3
        }
        else return 0
    }

    fun test2Odpowiedzi(wybor:Int){
        when(wybor){
            1 -> test2_check1.setTextColor(resources.getColor(R.color.rej))
            2 -> test2_check2.setTextColor(resources.getColor(R.color.rej))
            3 -> test2_check3.setTextColor(resources.getColor(R.color.rej))
        }
        if(wynik != 0) test2_check3.setTextColor(resources.getColor(R.color.akc))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        test2Odpowiedzi(wynik)
    }
}