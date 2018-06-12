package com.example.morningclass.myapplication

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.*
import kotlinx.android.synthetic.main.country_flag.*

class MainActivity : AppCompatActivity() {

    private val countries = arrayOf("brazil","canada","china","italy","japan","korea","mexico","thailand","turkey","usa")
    private val facts = arrayOf("brazil1111","canada1111","china1111","italy1111","japan1111","korea1111","mexico1111","thailand1111","turkey1111","usa1111")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//
//        //add textView
//        val tv = TextView(this)
//        tv.setText("Hello Kotlin Android")
//
//        //add button, width : half of screen
//        val display = windowManager.defaultDisplay
//        val endPoint = Point()
//        display.getSize(endPoint) // ger the display size put the size
//
//        val screenWidth = endPoint.x
//        val screenHeight = endPoint.y
//
//
//
//        val butt = Button(this)
//        butt.setText("Click me")
//
//
////        val layoutParams1 = ViewGroup.LayoutParams(
////                ViewGroup.LayoutParams.MATCH_PARENT,
////                ViewGroup.LayoutParams.WRAP_CONTENT)
//
//
////casting : viewGroup -> specific type of View ; more functions
//        val layoutParams1 = LinearLayout.LayoutParams(
//                screenWidth/2,
//                screenHeight/2)
//
//        layoutParams1.gravity = Gravity.BOTTOM
//        butt.layoutParams = layoutParams1
//        butt.gravity= Gravity.TOP or Gravity.CENTER
//
//
//        val  linearLayout = findViewById<LinearLayout>(R.id.main_Linear)
//        linearLayout.addView(tv)
//        linearLayout.addView(butt)
//        linearLayout.gravity = Gravity.BOTTOM


        val GridLayout = findViewById<GridLayout>(R.id.main_Linear)


        for(i in 0 until countries.size) {
            //inflate main view linear
            val countryBox = layoutInflater.inflate(R.layout.country_flag, null)
            val flagImage = countryBox.findViewById<ImageButton>(R.id.countryImgage)
            val countryName = countryBox.findViewById<TextView>(R.id.countryText)


            flagImage.setImageResource(resources.getIdentifier(countries[i],"drawable",packageName))
            countryName.text = countries[i].capitalize()

            flagImage.setOnClickListener{





//                //builder
//                var builder = AlertDialog.Builder(this)
//                builder.setTitle("Fact!")
//                builder.setMessage(facts[i])
//                builder.setPositiveButton("TRUE",DialogInterface.OnClickListener { dialog, which ->
//                    //when positive btn clicked
//
//                })
//
//                builder.setNegativeButton("FALSE",DialogInterface.OnClickListener { dialog, which ->
//                    //when negative btn clicked
//                })
//
//
//
//                //dialog
//                val alertDialog =builder.create()
//                alertDialog.show()


                val customDialog = CustomDialog(this)
                customDialog.show()
            }





            GridLayout.addView(countryBox)

        }

    }
}
