package com.example.jsco_pc.activitylifecycle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE :Int =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toast.makeText(this,"Create",Toast.LENGTH_LONG).show()

        goSecondId.setOnClickListener{
            var intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("name","Mary")
            intent.putExtra("age",21)
            //startActivity(intent)
            startActivityForResult(intent,REQUEST_CODE)
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"Pause",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Start",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Stop",Toast.LENGTH_LONG).show()
    }

    override fun onPostResume() {
        super.onPostResume()
        Toast.makeText(this,"PostResume",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Destroy",Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){
                var result=data!!.extras.get("secondName")
                Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }
}
