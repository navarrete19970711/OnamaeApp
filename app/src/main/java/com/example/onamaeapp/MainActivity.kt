package com.example.onamaeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1) viewを取得する
        val et:EditText = findViewById(R.id.et)
        val btnStart:Button = findViewById(R.id.btnStart)

        // 2) 画面遷移
        btnStart.setOnClickListener {
            // 7) 条件分岐
            if (et.text.toString() == ("")){
                // 7-1 トースト
                //Toast.makeText(this,"なんか書いて",Toast.LENGTH_LONG).show()
                // 7-2 アラートダイアログ
                AlertDialog.Builder(this)
                    .setTitle("ERROR!!")
                    .setMessage("なんか書いて")
                    .setPositiveButton("OK",null)
                    .show()
            }else{
                val intent = Intent(this,SecondActivity::class.java)

                // 3) 値を渡す
                intent.putExtra("MY_NAME",et.text.toString())

                startActivity(intent)
            }


        }

    }
}