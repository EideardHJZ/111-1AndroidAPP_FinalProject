package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvOrginContent = findViewById<TextView>(R.id.tvOriginContent)
        val tvWPM = findViewById<TextView>(R.id.tvWPM2)
        val tvRate = findViewById<TextView>(R.id.tvRate2)
        val tvTime = findViewById<TextView>(R.id.tvTime2)
        val tvAnswerContent = findViewById<TextView>(R.id.tvAnswerContent)
        val answer = SpannableStringBuilder(intent.getStringExtra("content"))
        val article: String? = intent.getStringExtra("articleTXT")
        //val time = (intent.getStringExtra("time")!!.toInt())
        var correct = 0
        var incorrect = 0

        tvOrginContent.text = article

        for (i in 0 until (answer.length))
        {
            if(answer[i] == article?.get(i))
            {
                correct += 1
            }
            else
            {
                incorrect += 1
            }
        }
        tvAnswerContent.text = answer
        //tvRate.text = (correct * 100/article!!.length).toString()
        //tvWPM.text = (correct/(60/time) - (incorrect)/(60/time)).toString()
        //tvTime.text = time.toString()



        btnBack.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

        //tvResult.text = "60秒內輸入的文字:$name\n處理用名稱為content\n\n原始文章內容為:$artical\n處理用名稱為articalTXT"
    }
}