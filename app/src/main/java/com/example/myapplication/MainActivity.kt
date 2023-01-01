package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.myButton)
        val myButton2 = findViewById<Button>(R.id.myButton2)
        val myButton3 = findViewById<Button>(R.id.myButton3)
        val myButton4 = findViewById<Button>(R.id.myButton4)
        val myButton5 = findViewById<Button>(R.id.myButton5)
        val myButton6 = findViewById<Button>(R.id.myButton6)
        val myButton7 = findViewById<Button>(R.id.myButton7)
        val myButton8 = findViewById<Button>(R.id.myButton8)
        val myButton9 = findViewById<Button>(R.id.myButton9)

        myButton.setOnClickListener {
            choose_bt(1)
        }
        myButton2.setOnClickListener {
            choose_bt(2)
        }
        myButton3.setOnClickListener {
            choose_bt(3)
        }
        myButton4.setOnClickListener {
            choose_bt(4)
        }
        myButton5.setOnClickListener {
            choose_bt(5)
        }
        myButton6.setOnClickListener {
            choose_bt(6)
        }
        myButton7.setOnClickListener {
            choose_bt(7)
        }
        myButton8.setOnClickListener {
            choose_bt(8)
        }
        myButton9.setOnClickListener {
            choose_bt(9)
        }
    }

    public fun choose_bt(ch_bt:Int){
        val intent = Intent(this, Running::class.java)

        intent.putExtra("btCH",ch_bt.toString())

        startActivity(intent)
    }
}