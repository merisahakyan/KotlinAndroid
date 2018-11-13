package com.example.jsco_pc.imageviewapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hairImg=hairImgView
        var beardImg=beardImageView

        hairImg.setOnClickListener{
            hairImg.clearColorFilter()
            hairImg.setColorFilter(Color.BLUE , PorterDuff.Mode.DARKEN)
        }

        beardImg.setOnClickListener{
            beardImg.clearColorFilter()
            beardImg.setColorFilter(Color.CYAN)
            beardImg.setBackgroundColor(Color.MAGENTA)
        }

    }
}
