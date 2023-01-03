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
        val times = SpannableStringBuilder(intent.getStringExtra("time")).toString().toInt()
        val tvRate = findViewById<TextView>(R.id.tvRate2)
        val tvWPM = findViewById<TextView>(R.id.tvWPM2)
        val tvTime = findViewById<TextView>(R.id.tvTime2)
        val tvJudge = findViewById<TextView>(R.id.tvJudge)
        var correct = 0
        var incorrect = 0
        var wpm = 0.0

        //Answer Check
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

        //Identify Article Language
        if(((article!![0].toInt() < 91 ) && (article!![0].toInt() > 64 )) || ((article!![0].toInt() > 96 ) && (article!![0].toInt() < 123)))
        {
            //Word Per Minute in English
            if((correct != 0) && (correct > incorrect))
            {
                wpm = ((correct/5) * (60/times.toDouble())) - ((incorrect/5) * (60/times.toDouble()))
            }
            else
            {
                wpm = 0.0
            }
        }
        else
        {
            //Word Per Minute in Chinese
            if((correct != 0) && (correct > incorrect))
            {
                wpm = (correct * (60/times.toDouble())) - (incorrect * (60/times.toDouble()))
            }
            else
            {
                wpm = 0.0
            }
        }

        //Accuracy Rate
        var rate: Int = if(answer.isNotEmpty()) {
            (correct * 100) / answer.length
        } else {
            0
        }

        //Overall Judge
        if(rate > 85 && (wpm > 15) && (wpm < 29))
        {
            tvJudge.text = "評級：Excellent"
        }
        else if (rate > 85 && (wpm > 30) && (wpm < 79))
        {
            tvJudge.text = "評級：Good"
        }
        else if (rate > 85 && (wpm > 80))
        {
            tvJudge.text = "評級：Fair"
        }
        else
        {
            tvJudge.text = "評級：Poor"
        }

        //Show Result
        tvOriginContent.text = article
        tvAnswerContent.text = answer
        tvRate.text = rate.toString()
        tvTime.text = times.toString()
        tvWPM.text = wpm.toInt().toString()

        btnBack.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }
    }
}