package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tx_result = findViewById<TextView>(R.id.textView5)
        val name = intent.getStringExtra("content")
        val artical = intent.getStringExtra("articalTXT")

        tx_result.text = "60秒內輸入的文字:$name\n處理用名稱為content\n\n原始文章內容為:$artical\n處理用名稱為articalTXT"

    }
}