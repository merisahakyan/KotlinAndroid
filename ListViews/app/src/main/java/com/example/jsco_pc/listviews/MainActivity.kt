package com.example.jsco_pc.listviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var names : Array<String> = arrayOf("Meri","Jenny","Lee","Arthur","James")

        var namesAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,names)
        listView.adapter = namesAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var itemName=listView.getItemAtPosition(position).toString()  
            Toast.makeText(this, "Id : $id  $itemName",Toast.LENGTH_LONG).show()
        }
    }
}
