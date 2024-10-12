package com.example.proyecto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val confirmationTextView = findViewById<TextView>(R.id.confirmationTextView)

        // Obtener los datos pasados desde la MainActivity
        val name = intent.getStringExtra("name")
        val birthDate = intent.getStringExtra("birthDate")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")
        val description = intent.getStringExtra("description")

        // Mostrar los datos en la vista
        confirmationTextView.text = """
            Nombre: $name
            Fecha de Nacimiento: $birthDate
            Teléfono: $phone
            Email: $email
            Descripción: $description
        """.trimIndent()

        val editButton = findViewById<Button>(R.id.editButton)
        editButton.setOnClickListener {
            // Regresar a MainActivity con los datos precargados
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("birthDate", birthDate)
            intent.putExtra("phone", phone)
            intent.putExtra("email", email)
            intent.putExtra("description", description)
            startActivity(intent)
        }
    }
}
