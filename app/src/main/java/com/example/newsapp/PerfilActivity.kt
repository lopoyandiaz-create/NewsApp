package com.example.newsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.titulo_perfil)

        // Flecha de volver (Perfil -> Noticias)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        // Intent explícito: Perfil -> Login (cierra sesión)
        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_perfil, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_buscar -> {
                Toast.makeText(this, "Búsqueda", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_correo -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_SUBJECT, getString(R.string.correo_asunto))
                }
                startActivity(intent)
                true
            }
            R.id.menu_privacidad -> {
                startActivity(Intent(this, PrivacidadActivity::class.java))
                true
            }
            R.id.menu_contactos -> {
                startActivity(Intent(this, ContactosActivity::class.java))
                true
            }
            R.id.menu_central -> {
                Toast.makeText(this, "Central", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}