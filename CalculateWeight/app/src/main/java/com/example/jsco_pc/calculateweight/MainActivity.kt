package com.example.jsco_pc.calculateweight

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {

    val marsGravity:Float = 0.38f
    val venusGravity:Float = 0.91f
    val jupiterGravity:Float = 2.34f
    var weight:Double=0.0
    var name:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showId.setOnClickListener{
            name = if(name=="")  "Earth"  else  name
            weight = if(weight==0.0) if(TextUtils.isEmpty(weightId.text.toString())) 0.0 else weightId.text.toString().toDouble() else weight
            resultId.text="Weight is ${weight.format(2).toString()} on $name"
        }

        marsCheckbox.setOnClickListener(this)
        venusCheckbox.setOnClickListener(this)
        jupiterCheckbox.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked:Boolean = v.isChecked
        weight= if(TextUtils.isEmpty(weightId.text.toString())) 0.0 else weightId.text.toString().toDouble()

        when(v.id){
            R.id.marsCheckbox -> if(isChecked){
                venusCheckbox.isChecked =false
                jupiterCheckbox.isChecked=false
                calculateWeight(weight.toString().toDouble(),v,"Mars")
            }
            R.id.venusCheckbox -> if(isChecked){
                marsCheckbox.isChecked =false
                jupiterCheckbox.isChecked=false
                calculateWeight(weight.toString().toDouble(),v,"Venus")
            }
            R.id.jupiterCheckbox -> if(isChecked){
                venusCheckbox.isChecked =false
                marsCheckbox.isChecked=false
                calculateWeight(weight.toString().toDouble(),v,"Jupiter")
            }
            else -> {
                name="Earth"
                calculateWeight(weight.toString().toDouble(), v, "Earth")
            }
        }
    }

    private fun calculateWeight(w:Double, checkBox:CheckBox , name:String)  {
        this.name=name
        when(checkBox.id){
            R.id.marsCheckbox -> weight=marsGravity*w
            R.id.venusCheckbox -> weight=venusGravity*w
            R.id.jupiterCheckbox -> weight=jupiterGravity*w
            else -> weight=w
        }
    }
    fun Double.format(digits:Int)=java.lang.String.format("%.${digits}f",this)
}
