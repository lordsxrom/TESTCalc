package ru.netology.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val result = findViewById<TextView>(R.id.result)
        val str = intent.getStringExtra("result") ?: "Нет резульата :("
        result.text = str
    }
}