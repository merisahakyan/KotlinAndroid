package com.example.jsco_pc.activitylifecycle

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

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

        backButton.setOnClickListener{
            var returnIntent=this.intent
            returnIntent.putExtra("secondName","Sahakyan")
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }
    }
}
