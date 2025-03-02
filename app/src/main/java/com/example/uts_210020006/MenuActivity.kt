package com.example.uts_210020006

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Atur padding untuk mengakomodasi sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar setup
        val toolbar = findViewById<Toolbar>(R.id.btn_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Menu Restoran"
        }

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewMenu)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data untuk daftar menu
        val menuList = DataMenu.menuList()

        // Adapter untuk RecyclerView
        val adapter = AdapterMenu(this, menuList) { menuItem ->
            // Handle klik tombol Detail
            Toast.makeText(this, "Detail: ${menuItem.menuName}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }

    // Tombol Back pada toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
