package com.example.onamaeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 4) viewを取得する
        val tvName:TextView = findViewById(R.id.tvName)
        val btnBack:Button = findViewById(R.id.btnBack)

        // 5) 値の受け取り
        val myName = intent.getStringExtra("MY_NAME")
        tvName.text = myName + "さん"

        // 6) 戻るボタン
        btnBack.setOnClickListener {
            finish()
        }

    }
}