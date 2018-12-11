package com.example.jsco_pc.recycleviewapp.data

import com.example.jsco_pc.recycleviewapp.model.Person
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.jsco_pc.recycleviewapp.R
import kotlin.coroutines.experimental.coroutineContext

class PersonListAdapter(private val list:ArrayList<Person>,
                        private val context:Context) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        //Create view from xml
        val view=LayoutInflater.from(context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItem(list[position])
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(item:Person){
            var name:TextView=itemView.findViewById(R.id.name) as TextView
            var age:TextView=itemView.findViewById(R.id.age) as TextView

            name.text = item.name
            age.text = item.age.toString()

            itemView.setOnClickListener {
                Toast.makeText(context,name.text,Toast.LENGTH_LONG).show()
            }
        }
    }
}