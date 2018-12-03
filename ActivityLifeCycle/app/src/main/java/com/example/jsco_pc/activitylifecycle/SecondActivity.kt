package com.example.jsco_pc.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var data=intent.extras
        if(data !=null){
            var name=data.get("name")
            var age=data.getInt("age")
            Toast.makeText(this,"${name.toString()} is ${age}",Toast.LENGTH_LONG).show()
        }
    }
}
