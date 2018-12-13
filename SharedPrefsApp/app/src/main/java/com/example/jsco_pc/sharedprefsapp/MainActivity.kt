package com.example.jsco_pc.sharedprefsapp

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_NAME="myPrefs"
    var myPref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {

            myPref = getSharedPreferences(PREFS_NAME, 0)

            var editor: SharedPreferences.Editor = (myPref as SharedPreferences)!!.edit()

            if (!TextUtils.isEmpty(enterInfo.text.toString())) {
                editor.putString("message", enterInfo.text.toString())
                editor.commit()
            } else {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_LONG).show()
            }

        }

        var dataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
        if (dataBack.contains("message")) {
            textView.text = dataBack.getString("message", "no message")
        }
    }
}
