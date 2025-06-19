package com.example.abgusov_lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация UI элементов
        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val analyzeButton = findViewById<Button>(R.id.analyzeButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        // Обработчик нажатия кнопки
        analyzeButton.setOnClickListener {
            val inputText = inputEditText.text.toString()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val latinLettersCount = countLatinLetters(inputText)
            resultTextView.text = "Найдено латинских букв: $latinLettersCount"
        }
    }

    //Функция для подсчета количества латинских букв в строке
    private fun countLatinLetters(text: String): Int {
        var count = 0

        for (char in text) {
            // Проверяем, является ли символ латинской буквой (a-z, A-Z)
            if (char in 'a'..'z' || char in 'A'..'Z') {
                count++
            }
        }

        return count
    }
}