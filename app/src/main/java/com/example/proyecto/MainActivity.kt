package com.example.proyecto

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var birthDateButton: Button
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var descriptionEditText: TextInputEditText
    private var birthDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        birthDateButton = findViewById(R.id.birthDateButton)
        phoneEditText = findViewById(R.id.phoneEditText)
        emailEditText = findViewById(R.id.emailEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)

        // Abrir DatePickerDialog al presionar el botón de la fecha de nacimiento
        birthDateButton.setOnClickListener {
            showDatePickerDialog()
        }

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("birthDate", birthDate)
            intent.putExtra("phone", phoneEditText.text.toString())
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("description", descriptionEditText.text.toString())
            startActivity(intent)
        }
    }

    // Mostrar DatePickerDialog
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            birthDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            birthDateButton.text = birthDate
        }, year, month, day)
        datePickerDialog.show()
    }
}
