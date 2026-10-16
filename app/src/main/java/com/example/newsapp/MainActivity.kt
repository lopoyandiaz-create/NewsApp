package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnIngresar.setOnClickListener {
            val correo = etCorreo.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (correo.isEmpty() || password.isEmpty()) {
                // Campos vacíos: mostrar error
                Toast.makeText(this, getString(R.string.error_campos), Toast.LENGTH_SHORT).show()
            } else {
                // Login simulado: cualquier dato es válido
                // Intent explícito: Login -> Noticias
                val intent = Intent(this, NoticiasActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnRegistrar.setOnClickListener {
            Toast.makeText(this, "Registro simulado", Toast.LENGTH_SHORT).show()
        }
    }
}