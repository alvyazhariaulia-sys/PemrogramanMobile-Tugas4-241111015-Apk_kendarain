package com.utama.aplikasikendarin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register_Kendarain : AppCompatActivity() {

    // Deklarasi variabel
    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnDaftar: Button
    private lateinit var tvToLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hubungkan ke layout XML yang sudah dihapus Tab-nya
        setContentView(R.layout.activity_register_kendarain)

        // Inisialisasi View berdasarkan ID di XML
        etNama = findViewById(R.id.etNama)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnDaftar = findViewById(R.id.btnDaftar)
        tvToLogin = findViewById(R.id.tvToLogin)

        // Logika ketika tombol Daftar Sekarang diklik
        btnDaftar.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Validasi input kosong
            if (nama.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
            }
            // Validasi apakah password dan konfirmasi cocok
            else if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
            }
            else {
                // Jika semua valid, tampilkan pesan sukses
                Toast.makeText(this, "Registrasi Berhasil, Halo $nama!", Toast.LENGTH_LONG).show()

                // Berpindah ke halaman LoginKendarain
                val intent = Intent(this, LoginKendarain::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Logika teks "Sudah punya akun? Masuk"
        tvToLogin.setOnClickListener {
            val intent = Intent(this, LoginKendarain::class.java)
            startActivity(intent)
            finish()
        }
    }
}
