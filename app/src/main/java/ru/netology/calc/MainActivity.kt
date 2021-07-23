package ru.netology.calc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var a: Int = -1
    var b: Int = -1
    var r: Int = -1
    var sign: String = ""

    lateinit var resultView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultView = findViewById(R.id.textView)

        val showResultButton = findViewById<Button>(R.id.show_result_button)
        showResultButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("result", resultView.text)
            startActivity(intent)
        }
    }

    override fun onClick(view: View?) {
        Toast.makeText(this, (view as? Button)?.text, Toast.LENGTH_SHORT).show()

        ((view as? Button)?.text as? String)?.let { number ->
            when {
                number == "+" -> {
                    sign = number
                    resultView.text = "0"
                }
                number == "=" -> {
                    sign = number
                    resultView.text = (a + b).toString()
                }
                a == -1 && b == -1 && r == -1 -> {
                    a = number.toInt()
                    resultView.text = number
                }
                a != -1 && b == -1 && r == -1 -> {
                    b = number.toInt()
                    resultView.text = number
                }
            }
        }
    }

}