package com.example.afmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        val mainView = findViewById<View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Login UI elements
        val signUpText = findViewById<TextView>(R.id.signUpText)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Sign Up Overlay elements
        val signUpLayout = findViewById<View>(R.id.signUpLayout)
        val overlayBackground = findViewById<View>(R.id.overlayBackground)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        
        val regUsername = findViewById<EditText>(R.id.regUsername)
        val regEmail = findViewById<EditText>(R.id.regEmail)
        val regPassword = findViewById<EditText>(R.id.regPassword)
        val regRePassword = findViewById<EditText>(R.id.regRePassword)

        // Login Action
        btnLogin.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            
            if (email == "example@email.com" && password == "12345678") {
                Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show()
                // Navigate to Profile Activity
                startActivity(Intent(this, ProfileActivity::class.java))
            } else if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        // Show Sign Up Overlay
        signUpText.setOnClickListener {
            signUpLayout.visibility = View.VISIBLE
            overlayBackground.visibility = View.VISIBLE
        }

        // Hide Sign Up Overlay
        btnCancel.setOnClickListener {
            signUpLayout.visibility = View.GONE
            overlayBackground.visibility = View.GONE
        }

        // Sign Up Action
        btnSignUp.setOnClickListener {
            val username = regUsername.text.toString()
            val email = regEmail.text.toString()
            val password = regPassword.text.toString()
            val rePassword = regRePassword.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != rePassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Account created for $username", Toast.LENGTH_SHORT).show()
                signUpLayout.visibility = View.GONE
                overlayBackground.visibility = View.GONE
            }
        }

        // Forgot Password Action
        forgotPasswordText.setOnClickListener {
            Toast.makeText(this, "Redirecting to password recovery...", Toast.LENGTH_SHORT).show()
        }
    }
}