package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.pow

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
        val comment = findViewById<TextView>(R.id.comment)

        button.setOnClickListener {
            val weight: Double = weightField.text.toString().toDouble()
            val height: Double = heightField.text.toString().toDouble()
            val imcValue = calculateIMC(weight, height)
            imc.text = String.format("%.2f", imcValue)

            if (imcValue <= 18.5) {
                comment.text = "Subponderal"
            } else if (imcValue in 18.5..24.9) {
                comment.text = "Normal"
            } else if (imcValue in 25.0..29.9) {
                comment.text = "Supraponderal"
            } else {
                comment.text = "Obez"
            }
        }

        reset.setOnClickListener {
            weightField.setText("")
            heightField.setText("")
            imc.text = "IMC"
            comment.text = ""
        }

    }

    private fun calculateIMC(weight: Double, height: Double): Double {
        val imc = weight / pow((height / 100), 2.0)
        return imc
    }
}