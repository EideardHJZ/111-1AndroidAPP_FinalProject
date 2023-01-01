package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class Running : AppCompatActivity() {
    var status_ch = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running)
        val tx_show = findViewById<TextView>(R.id.textView)
        val ed_gt = findViewById<EditText>(R.id.editTextTextPersonName)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val tx_time = findViewById<TextView>(R.id.tx_time)


        val countDownTimer:CountDownTimer
        var countDT: Long = 61000
        var countIl: Long = 1000

        var substr = ""

        val btch = intent.getStringExtra("btCH")


////////////要顯示的文章
        val sh1 = "1"
        val sh2 = "2"
        val sh3 = "3"
        val sh4 = "4"
        val sh5 = "5"
        val sh6 = "6"
        val sh7 = "7"
        val sh8 = "8"
        val sh9 = "9"
//



        if(status_ch == true){
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        else{

            if(btch == "1"){
                substr = sh1
                tx_show.text = sh1}
            else if(btch == "2"){
                substr = sh2
                tx_show.text = sh2}
            else if(btch == "3"){
                substr = sh3
                tx_show.text = sh3}
            else if(btch == "4"){
                substr = sh4
                tx_show.text = sh4}
            else if(btch == "5"){
                substr = sh5
                tx_show.text = sh5}
            else if(btch == "6"){
                substr = sh6
                tx_show.text = sh6}
            else if(btch == "7"){
                substr = sh7
                tx_show.text = sh7}
            else if(btch == "8"){
                substr = sh8
                tx_show.text = sh8}
            else{
                substr = sh9
                tx_show.text = sh9}




            countDownTimer = object : CountDownTimer(countDT,countIl){
                override fun onTick(p0: Long) {
                    tx_time.text = (p0/1000).toString()


                }

                override fun onFinish() {
                    tx_time.text = ""
                    status_ch = true
                    resetPr(substr)

                }
            }
            countDownTimer.start()

            btn_send.setOnClickListener({

                countDownTimer.cancel()
                status_ch = true
                resetPr(substr)
            })
        }




    }


    private fun resetPr(str:String){
        val ed_gt = findViewById<EditText>(R.id.editTextTextPersonName)
        val tx_show = findViewById<TextView>(R.id.textView)
        val tx_time = findViewById<TextView>(R.id.tx_time)
        val intent = Intent(this, Result::class.java)
        val intext = ed_gt.text.toString()
        intent.putExtra("content",intext)
        intent.putExtra("articalTXT",str)
        ed_gt.text.clear()
        tx_show.text = ""
        tx_time.text = ""



        startActivity(intent)
    }


}