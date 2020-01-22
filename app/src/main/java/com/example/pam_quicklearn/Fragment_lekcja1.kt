package com.example.pam_quicklearn

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lekcja1.*

class Fragment_lekcja1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_lekcja1, container, false)

        return view
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val napis = getString(R.string.frag1_hamiltontext) + "\n\n" + getString(R.string.frag1_hansentext) + "\n\n" + getString(R.string.frag1_heatherstext)
        frag1_tekst.text = napis

    }

}