package com.utama.aplikasikendarin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inisialisasi View Utama
        val tvWelcome = findViewById<TextView>(R.id.tvWelcomeUser)
        val tvSeeAll = findViewById<TextView>(R.id.tvSeeAllBrands)
        val cardPorschePromo = findViewById<CardView>(R.id.cardPromo)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // 2. Inisialisasi Masing-masing Brand
        val brandPorsche = findViewById<View>(R.id.brandPorsche)
        val brandToyota = findViewById<View>(R.id.brandBmw)

        // 3. Menampilkan Nama User dari Login
        val username = intent.getStringExtra("username")
        if (!username.isNullOrEmpty()) {
            tvWelcome.text = "Halo, $username!"
        }

        // 4. Navigasi Klik Teks "Lihat Semua" (Tanpa filter, muncul semua)
        tvSeeAll.setOnClickListener {
            startActivity(Intent(this, ListKendaraanActivity::class.java))
        }

        // 5. Navigasi Klik Card Promo Porsche
        cardPorschePromo.setOnClickListener {
            val intent = Intent(this, ListKendaraanActivity::class.java)
            intent.putExtra("NAMA_BRAND", "Porsche")
            startActivity(intent)
            Toast.makeText(this, "Menampilkan Promo Porsche", Toast.LENGTH_SHORT).show()
        }

        // 6. Logika Klik pada Icon Merek (Brand) dengan Filter
        brandPorsche.setOnClickListener {
            val intent = Intent(this, ListKendaraanActivity::class.java)
            intent.putExtra("NAMA_BRAND", "Porsche") // Mengirim kunci "Porsche"
            startActivity(intent)
            Toast.makeText(this, "Kategori: Porsche", Toast.LENGTH_SHORT).show()
        }

        brandToyota.setOnClickListener {
            val intent = Intent(this, ListKendaraanActivity::class.java)
            intent.putExtra("NAMA_BRAND", "Toyota") // Mengirim kunci "Toyota"
            startActivity(intent)
            Toast.makeText(this, "Kategori: Toyota", Toast.LENGTH_SHORT).show()
        }

        // 7. Logika Klik Bottom Navigation (Navbar)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Anda sedang di Beranda", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_kendaraan -> {
                    startActivity(Intent(this, ListKendaraanActivity::class.java))
                    true
                }
                R.id.nav_transaksi -> {
                    Toast.makeText(this, "Menu Riwayat Transaksi", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this, "Menu Profil Pengguna", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
