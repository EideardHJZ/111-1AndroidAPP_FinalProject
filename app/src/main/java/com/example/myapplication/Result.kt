package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvOriginContent = findViewById<TextView>(R.id.tvOriginContent)
        val article: String? = intent.getStringExtra("articleTXT")
        val tvAnswerContent = findViewById<TextView>(R.id.tvAnswerContent)
        val answer = SpannableStringBuilder(intent.getStringExtra("content"))
        val tvRate = findViewById<TextView>(R.id.tvRate2)
        val tvWPM = findViewById<TextView>(R.id.tvWPM2)
        val tvTime = findViewById<TextView>(R.id.tvTime2)
        val tvJudge = findViewById<TextView>(R.id.tvJudge)
        //val time = (intent.getStringExtra("time")!!.toInt())

        var correct = 0
        var incorrect = 0
        var rate = 0
        var wpm = 0
        tvOriginContent.text = article

        for (i in 0 until (answer.length))
        {
            if(answer[i] == article?.get(i))
            {
                correct += 1
                answer.setSpan(ForegroundColorSpan(Color.BLACK), i, i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            else
            {
                incorrect += 1
                answer.setSpan(ForegroundColorSpan(Color.RED), i, i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }

        tvAnswerContent.text = answer
        rate = (correct * 100) / article!!.length
        if(rate > 85 && (wpm > 15) && (wpm < 29))
        {
            tvJudge.text = "Excellent"
        }
        else if (rate > 85 && (wpm > 30) && (wpm < 79))
        {
            tvJudge.text = "Good"
        }
        else if (rate > 85 && (wpm > 80))
        {
            tvJudge.text = "Fair"
        }
        else
        {
            tvJudge.text = "Poor"
        }
        tvRate.text = rate.toString()
        //tvWPM.text = (correct/(60/time) - (incorrect)/(60/time)).toString()
        //tvTime.text = time.toString()



        btnBack.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

        //tvResult.text = "60秒內輸入的文字:$name\n處理用名稱為content\n\n原始文章內容為:$artical\n處理用名稱為articalTXT"
    }
}