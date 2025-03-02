package com.example.uts_210020006

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlamatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)

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
            title = "Alamat Restoran"
        }

        // Mengatur tombol untuk mengganti fragment
        val buttonFragmentCabangA = findViewById<Button>(R.id.buttonCabangA)
        val buttonFragmentCabangB = findViewById<Button>(R.id.buttonCabangB)

        buttonFragmentCabangA.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FragmentCabangA())
                .commit()
        }

        buttonFragmentCabangB.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, FragmentCabangB())
                .commit()
        }
    }

    // Tombol Back pada toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish() // Kembali ke activity sebelumnya
        return true
    }
}
