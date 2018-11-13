package com.example.jsco_pc.imagefilter

import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener{
            imageView.clearColorFilter()
            imageView.setColorFilter(Color.rgb(getRandomInteger(),getRandomInteger(),getRandomInteger()),PorterDuff.Mode.OVERLAY)
        }
    }

    fun getRandomInteger():Int{
        var rand=Random()
        return rand.nextInt()
    }
}
