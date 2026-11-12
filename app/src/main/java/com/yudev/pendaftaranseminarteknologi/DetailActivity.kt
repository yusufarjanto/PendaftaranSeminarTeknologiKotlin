package com.yudev.pendaftaranseminarteknologi

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : Activity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnSelesai = findViewById<Button>(R.id.btnSelesai)

        val nama = intent.getStringExtra("EXTRA_NAMA")
            ?: "Peserta"

        val umur = intent.getIntExtra("EXTRA_UMUR", 0)

        tvHasil.text = """
            Halo $nama,
            usia Anda $umur tahun.

            Selamat!
            Pendaftaran Seminar Teknologi
            berhasil!
        """.trimIndent()

        btnSelesai.setOnClickListener {
            finish()
        }
    }
}
