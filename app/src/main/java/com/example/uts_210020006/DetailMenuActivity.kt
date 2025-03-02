package com.example.uts_210020006

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        // Menyesuaikan padding dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.btn_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Detail Menu"
        }

        // Ambil data dari Intent
        val menuName = intent.getStringExtra("extra_menu_name") ?: "Soto Ayam"
        val menuImage = intent.getIntExtra("extra_menu_image", 1)
        val menuPrice = intent.getStringExtra("extra_menu_price") ?: "Rp.35.000"
        val menuDescription = intent.getStringExtra("extra_menu_description") ?: "Termasuk nasi, paha atas/dada, sambal, sayur, dan seterusnya."

        // Tampilkan data di UI
        findViewById<ImageView>(R.id.imageMenuDetail).setImageResource(menuImage)
        findViewById<TextView>(R.id.textMenuNameDetail).text = menuName
        findViewById<TextView>(R.id.textMenuPriceDetail).text = menuPrice
        findViewById<TextView>(R.id.textMenuDescriptionDetail).text = menuDescription
    }

    // Tombol Back pada toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Kembali ke MenuActivity
        return true
    }
}
