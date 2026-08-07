package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var nombre: EditText
    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton = findViewById(R.id.boton)
        nombre = findViewById(R.id.nombre)
        texto = findViewById(R.id.text)

        boton.setOnClickListener {
            val user = nombre.text.toString()
            texto.text = "Hola $user!"

            boton.setOnClickListener {
                val intent = Intent(this,MySecondActivity::class.java)
                intent.putExtra("nombre_usuario",nombre.text.toString())
                startActivity(intent)
            }
        }
    }
}