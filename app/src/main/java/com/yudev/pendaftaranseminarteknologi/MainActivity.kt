package com.yudev.pendaftaranseminarteknologi

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.net.toUri

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsia = findViewById<EditText>(R.id.etUsia)
        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnInfo = findViewById<Button>(R.id.btnInfo)

        btnKirim.setOnClickListener {

            val nama = etNama.text.toString().trim()
            val inputUsia = etUsia.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama wajib diisi!"
                etNama.requestFocus()

                Toast.makeText(
                    this,
                    "Silakan isi nama lengkap",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (inputUsia.isEmpty()) {
                etUsia.error = "Usia wajib diisi!"
                etUsia.requestFocus()

                Toast.makeText(
                    this,
                    "Silakan isi usia",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val usia = inputUsia.toIntOrNull()

            if (usia == null || usia !in 1..120) {
                etUsia.error = "Masukkan usia valid (1-120)"
                etUsia.requestFocus()

                Toast.makeText(
                    this,
                    "Usia harus berupa angka yang valid",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }
            // Mengirim String dan Integer ke halaman kedua
            val intent = Intent(
                this,
                DetailActivity::class.java
            )

            intent.putExtra("EXTRA_NAMA", nama)
            intent.putExtra("EXTRA_UMUR", usia)

            startActivity(intent)
        }

        btnInfo.setOnClickListener {

            val url = "https://instagram.com/yusufarjanto"

            val intent = Intent(
                Intent.ACTION_VIEW,
                url.toUri()
            )

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "Tidak ada aplikasi untuk membuka link",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
