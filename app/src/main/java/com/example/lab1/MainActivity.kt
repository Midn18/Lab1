package com.example.lab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculateBtn)
        val weight = findViewById<TextInputLayout>(R.id.weight)
        val height = findViewById<TextInputLayout>(R.id.height)
        weight.editText?.text
        button.setOnClickListener{
        }
    }
}