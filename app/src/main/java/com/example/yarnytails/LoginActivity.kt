package com.example.yarnytails

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val joinUsText = findViewById<TextView>(R.id.joinUsText)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"Please enter all Fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entering ...", Toast.LENGTH_SHORT).show()
            }

            joinUsText.setOnClickListener {
                Toast.makeText(this, "Welcome to the Tribe ...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}