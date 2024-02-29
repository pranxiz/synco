package com.final_project.synco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.final_project.synco.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputLayout


class login_page : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    lateinit var email: TextInputLayout
    lateinit var password: TextInputLayout
    lateinit var loginbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = findViewById(R.id.emailLayout)
        password = findViewById(R.id.passwordLayout)
        loginbutton = findViewById(R.id.loginButton)

        binding.TextView.setOnClickListener {
            val intent = Intent (this, signup_page::class.java)
            startActivity(intent)
        }

        loginbutton.setOnClickListener {
            if (validateForm()) {
                startActivity(Intent(this, Spage::class.java))
            }
        }
    }

    private fun validateForm(): Boolean {
        if (email.editText?.text.toString().isEmpty()) {
            email.error = "Email is required"
            return false
        }
        if (password.editText?.text.toString().isEmpty()) {
            password.error = "Password is required"
            return false
        }
        return true
    }
}