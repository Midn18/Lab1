package com.example.lab1

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.pow
import java.lang.String.format
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculateBtn)
        val reset = findViewById<Button>(R.id.resetButton)
        val weightField = findViewById<EditText>(R.id.weight)
        val heightField = findViewById<EditText>(R.id.height)
        val imc = findViewById<TextView>(R.id.result)

        button.setOnClickListener {
            val weight: Double = weightField.text.toString().toDouble()
            val height: Double = heightField.text.toString().toDouble()
            val imcValue = calculateIMC(weight, height)
            imc.text = String.format("%.2f", imcValue)
        }

        reset.setOnClickListener {
            weightField.setText("")
            heightField.setText("")
            imc.text = "IMC"
        }

    }

    private fun calculateIMC(weight: Double, height: Double): Double {
        val imc = weight / (pow((height / 100), 2.0))
        return imc
    }
}