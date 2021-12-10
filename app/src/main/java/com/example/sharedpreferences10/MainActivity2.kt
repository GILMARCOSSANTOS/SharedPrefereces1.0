package com.example.sharedpreferences10

import android.content.Context


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView2 = findViewById<TextView>(R.id.textViewTextoId2)
        val textView3 = findViewById<TextView>(R.id.textViewTextoId3)

        val result = getSharedPreferences("chaveGeral", Context.MODE_PRIVATE)
        val valor = result.getString("txt", "No imported")
        textView2.setText(valor)

        if (valor != "No imported") {
            textView3.setText(valor)

        }

    }
}

