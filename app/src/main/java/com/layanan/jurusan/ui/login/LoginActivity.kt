package com.layanan.jurusan.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.layanan.jurusan.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)
    }
}