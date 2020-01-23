package com.example.pam_quicklearn

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lekcja3.*

class Fragment_lekcja3(val con:Context, val state:PlayerState) : Fragment() {

    lateinit var playerHolder: PlayerHolder


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_lekcja3, container, false)

        return view
    }

    fun setHamilton(){
        playerHolder.stop()
        playerHolder.playerState.source = SourceType.local_video
        playerHolder.playerState.whenReady = false
        playerHolder.playerState.position = 0
        playerHolder.playerState.window = 0
        playerHolder.playerState.uristringVideo =  "assets:///Hamilton-Film.mp4"
        playerHolder.start()
        Log.d("COS", "Dokonane")
    }

    fun setHansen(){
        playerHolder.stop()
        playerHolder.playerState.source = SourceType.local_video
        playerHolder.playerState.whenReady = false
        playerHolder.playerState.position = 0
        playerHolder.playerState.window = 0
        playerHolder.playerState.uristringVideo =  "assets:///Hansen-Film.mp4"
        playerHolder.start()
        Log.d("COS", "Dokonane")
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
        super.onDestroy()
        playerHolder.release()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playerHolder = PlayerHolder(con, exoplayer_fragmentlekcja3, state)
        playerHolder.playerState.source = SourceType.local_video
        playerHolder.playerState.position = 0
        playerHolder.playerState.window = 0
        playerHolder.playerState.whenReady = false
        playerHolder.playerState.uristringVideo =  "assets:///Hansen-Film.mp4"

        val napis = getString(R.string.hamilton) + "\n\n" + getString(R.string.frag3_hamiltontext) + "\n\n" + getString(R.string.hansen) + "\n\n" + getString(R.string.frag3_hansentext)
        frag3_tekst.text = napis

    }
}