package com.example.newsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactosActivity : AppCompatActivity() {

    private val contactos = listOf(
        "Prensa Editorial: +51 1 987987987",
        "Prensa Editorial: +51 1 987987987",
        "Prensa Editorial: +51 1 987987987",
        "Prensa Editorial: +51 1 987987987",
        "Prensa Editorial: +51 1 987987987",
        "Prensa Editorial: +51 1 987987987"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.titulo_contactos)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val lvContactos = findViewById<ListView>(R.id.lvContactos)
        lvContactos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactos)

        registerForContextMenu(lvContactos)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val contacto = contactos[info.position]
        // Extrae solo el número del texto: "+51 1 987987987"
        val numero = contacto.substringAfter(":").trim().replace(" ", "")

        return when (item.itemId) {
            R.id.ctx_llamar -> {
                // Intent implícito: abre el marcador
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numero")))
                true
            }
            R.id.ctx_mensaje -> {
                // Intent implícito: abre la app de mensajes
                startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$numero")))
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}