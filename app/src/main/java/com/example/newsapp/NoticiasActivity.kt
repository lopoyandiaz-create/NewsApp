package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class NoticiasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val btnCompartir = findViewById<ImageView>(R.id.btnCompartir)

        val btnPerfil = findViewById<ImageView>(R.id.btnPerfil)
        btnPerfil.setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }

        btnCompartir.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.noticia1_titulo))
                putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.noticia1_titulo) + "\n\n" + getString(R.string.noticia_texto)
                )
            }
            startActivity(Intent.createChooser(intent, getString(R.string.titulo_compartir)))
        }
    }
}