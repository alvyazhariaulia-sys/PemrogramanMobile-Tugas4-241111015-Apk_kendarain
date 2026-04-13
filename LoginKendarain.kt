package com.utama.aplikasikendarin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Disarankan ganti nama class jadi LoginKendarain agar sama dengan nama file
class LoginKendarain : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvToRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pastikan nama layout XML-nya juga benar
        setContentView(R.layout.activity_login_kendarain)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvToRegister = findViewById(R.id.tvToRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", email)
                startActivity(intent)
                finish()
            }
        }

        tvToRegister.setOnClickListener {
            val intent = Intent(this, Register_Kendarain::class.java)
            startActivity(intent)
        }
    }
}
