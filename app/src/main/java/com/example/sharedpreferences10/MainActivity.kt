package com.example.sharedpreferences10

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Declaração de variáveis:
         */
        val botaoSalvar = findViewById<Button>(R.id.botaoSalvarId)
        val mostrarTexto = findViewById<Button>(R.id.botaoClicarParaExibirTexto)

        /**
         * Chave do Shared Preference:
         */
        shared = getSharedPreferences("chaveGeral", Context.MODE_PRIVATE)

        /**
         * Botão salvar dados:
         */
        botaoSalvar.setOnClickListener {
            //Declaração de variáveis:
            val digiteNome = findViewById<EditText>(R.id.editTextDigiteSeuNomeId)

            //ABAIXO: VERSÃO ORIGINAL:
            //Salvar informações no Shared:
            /* val edit = shared.edit()
             edit.putString("txt", digiteNome.text.toString())
             Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
             edit.apply()*/

            val edit = shared.edit()
            edit.putString("txt", digiteNome.text.toString())
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
            edit.apply()
        }

        mostrarTexto.setOnClickListener {
            val textViewtexto = findViewById<TextView>(R.id.textViewTextoId)
            textViewtexto.text = shared.getString("txt", "No imported")
            Toast.makeText(this, shared.getString("txt", "No imported"), Toast.LENGTH_SHORT)
                .show()

        }

        val botaoNavegar = findViewById<Button>(R.id.botaoSegundaActivity)
        botaoNavegar.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
            }
            startActivity(intent)

        }

    }


}

