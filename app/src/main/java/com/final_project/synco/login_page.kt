package com.final_project.synco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.final_project.synco.databinding.ActivityLoginPageBinding


class login_page : AppCompatActivity() {

        private lateinit var binding: ActivityLoginPageBinding

        lateinit var email: EditText
        lateinit var password: EditText
        lateinit var loginbutton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityLoginPageBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.TextView.setOnClickListener {
                val intent = Intent (this, signup_page::class.java)
                startActivity(intent)
            }

            binding.loginButton.setOnClickListener {
                if (binding.email.text.toString() == "email" && binding.Password.text.toString() == "1234") {
                    startActivity(Intent(this, Spage::class.java))
                } else {
                    Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }