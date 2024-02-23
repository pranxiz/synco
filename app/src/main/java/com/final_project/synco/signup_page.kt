package com.final_project.synco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.final_project.synco.databinding.ActivitySignupPageBinding

class signup_page : AppCompatActivity() {
    private lateinit var binding: ActivitySignupPageBinding

    lateinit var email: EditText
    lateinit var fassword: EditText
    lateinit var sassword: EditText
    lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TextView.setOnClickListener {
            val intent = Intent (this, login_page::class.java)
            startActivity(intent)
        }

        binding.signupButton.setOnClickListener {
            val email = binding.email.text.toString()
            val pass = binding.fassword.text.toString()
            val confirmPass = binding.sassword.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                } else {
                    Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Field!!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}