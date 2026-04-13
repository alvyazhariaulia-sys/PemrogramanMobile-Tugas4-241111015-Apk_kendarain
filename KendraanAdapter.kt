package com.utama.aplikasikendarin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Samakan nama variabel konstruktornya: listKendaraan
class KendaraanAdapter(private val listKendaraan: List<Kendaraan>) :
    RecyclerView.Adapter<KendaraanAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Samakan ID dengan yang ada di item_kendaraan.xml kamu
        val nama: TextView = view.findViewById(R.id.tvNama)
        val deskripsi: TextView = view.findViewById(R.id.tvDeskripsi) // Tambahkan deskripsi
        val harga: TextView = view.findViewById(R.id.tvHarga)
        val gambar: ImageView = view.findViewById(R.id.imgKendaraan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kendaraan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kendaraan = listKendaraan[position]
        holder.nama.text = kendaraan.nama
        holder.deskripsi.text = kendaraan.deskripsi // Tambahkan ini
        holder.harga.text = kendaraan.harga
        holder.gambar.setImageResource(kendaraan.gambar)
    }

    override fun getItemCount(): Int = listKendaraan.size
}
