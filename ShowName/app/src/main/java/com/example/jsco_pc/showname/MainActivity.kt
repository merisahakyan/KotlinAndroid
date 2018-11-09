package com.example.jsco_pc.showname

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name=nameId.text

        showId.setOnClickListener{
            resultId.text="Welcome $name !"
        }
    }
}
