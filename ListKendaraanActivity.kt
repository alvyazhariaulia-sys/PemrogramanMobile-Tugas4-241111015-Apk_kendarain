package com.utama.aplikasikendarin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListKendaraanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_kendaraan)

        // 1. Tangkap data brand yang dikirim dari MainActivity
        val brandTerpilih = intent.getStringExtra("NAMA_BRAND")

        // 2. Daftar Semua Kendaraan (Master Data)
        val semuaKendaraan = listOf(
            Kendaraan(
                "Porsche 911 Carrera",
                "Rp 5.500.000 / Hari",
                "Mobil sport legendaris...",
                R.drawable.porsche
            ),
            Kendaraan(
                "Toyota Alphard",
                "Rp 2.500.000 / Hari",
                "MPV mewah luas...",
                R.drawable.alphard
            ),
            Kendaraan(
                "Honda CBR250RR",
                "Rp 450.000 / Hari",
                "Motor sport kencang...",
                R.drawable.cbr
            )
        )

        // 3. Logika Filter
        // Jika brandTerpilih tidak kosong, kita saring. Jika kosong (klik Lihat Semua), tampilkan semua.
        val dataTampil = if (!brandTerpilih.isNullOrEmpty()) {
            semuaKendaraan.filter { it.nama.contains(brandTerpilih, ignoreCase = true) }
        } else {
            semuaKendaraan
        }

        // 4. Inisialisasi RecyclerView
        val rvKendaraan = findViewById<RecyclerView>(R.id.rvKendaraan)
        rvKendaraan.layoutManager = LinearLayoutManager(this)

        // Gunakan data yang sudah difilter (dataTampil)
        val adapter = KendaraanAdapter(dataTampil)
        rvKendaraan.adapter = adapter
    }
}
