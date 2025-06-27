package com.example.yarnytails

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yarnytails.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,"Please enter all Fields", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(username,password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Entering ...", Toast.LENGTH_SHORT).show()
                        val loggedIntent = Intent(this, MainActivity::class.java)
                        startActivity(loggedIntent)
                        finish()
                    } else {
                        Toast.makeText(this, "Not able to enter with that ... ${task.exception?.message}", Toast.LENGTH_LONG).show()
//                        the below code if you want to know why login failed
//                        val errorMessage = when (val exception = task.exception) {
//                            is FirebaseAuthInvalidUserException -> "No account found with this email."
//                            is FirebaseAuthInvalidCredentialsException -> "Incorrect password. Please try again."
//                            else -> "Login failed: ${exception?.localizedMessage}"
//                        }
//                        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        binding.joinUsText.setOnClickListener {
            Toast.makeText(this, "Welcome to the Tribe ...", Toast.LENGTH_SHORT).show()
            val signupIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signupIntent)
            finish()
        }
    }
}