package com.example.tabhostdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextSwitcher
import android.widget.TextView

class TextSwitcherActivity : AppCompatActivity() {
    private val languages = arrayOf("Java","Python","Kotlin","Scala","C++")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_switcher)

        // accessing the TextSwitcher from XML layout
        val textSwitcher = findViewById<TextSwitcher>(R.id.textSwitcher)
        textSwitcher.setFactory {
            val textView = TextView(this)
            textView.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            textView.textSize = 32f
            textView.setTextColor(Color.BLUE)
            textView
        }
        textSwitcher.setText(languages[index])

        val textIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left)
        textSwitcher.inAnimation = textIn

        val textOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right)
        textSwitcher.outAnimation = textOut

        // previous button functionality
        val prev = findViewById<Button>(R.id.prev)
        prev.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 4
            textSwitcher.setText(languages[index])
        }
        // next button functionality
        val button = findViewById<Button>(R.id.next)
        button.setOnClickListener {
            index = if (index + 1 < languages.size) index + 1 else 0
            textSwitcher.setText(languages[index])
        }
    }
}