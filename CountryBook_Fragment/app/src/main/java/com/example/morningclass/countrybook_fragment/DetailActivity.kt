package com.example.morningclass.countrybook_fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_detail)

        val countryName = intent.getStringExtra("name")

        val titleTV = findViewById<TextView>(R.id.country_name)
        titleTV.setText(countryName.capitalize())

        val descriptionTv = findViewById<TextView>(R.id.country_description)
        descriptionTv.setText("1")
    }
}
