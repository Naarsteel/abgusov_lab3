package com.example.abgusov_lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.root)
        rootLayout.setOnClickListener {
            hideKeyboard()
        }

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

            hideKeyboard()
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

    //Функция для скрытия клавиатуры после нажатия кнопки
    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}