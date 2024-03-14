package com.final_project.synco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.final_project.synco.databinding.ActivityLoginPageBinding
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login_page : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    lateinit var emailLayout: TextInputLayout
    lateinit var passwordLayout: TextInputLayout
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailLayout = binding.emailLayout
        passwordLayout = binding.passwordLayout
        loginButton = binding.loginButton

        binding.TextView.setOnClickListener {
            val intent = Intent (this, signup_page::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            if (validateForm()) {
                loginUser()
            }
        }
    }

    private fun validateForm(): Boolean {
        val email = emailLayout.editText?.text.toString().trim()
        val password = passwordLayout.editText?.text.toString().trim()

        if (email.isEmpty()) {
            emailLayout.error = "Email is required"
            return false
        }
        if (password.isEmpty()) {
            passwordLayout.error = "Password is required"
            return false
        }
        return true
    }

    private fun loginUser() {
        val email = emailLayout.editText?.text.toString().trim()
        val password = passwordLayout.editText?.text.toString().trim()

        val apiService = RetrofitClient.getService()
        val call = apiService.loginUser(LoginUser(email = email, password = password))

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val authToken = "Bearer ${response.body()?.token}"
                    val intent = Intent(this@login_page, Spage::class.java)
                    intent.putExtra("authToken", authToken)
                    startActivity(intent)
                    finish()
                } else {
                    val errorMessage = "Login failed. Please check your credentials."
                    emailLayout.error = errorMessage
                    passwordLayout.error = errorMessage
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val errorMessage = "Login request failed. Please try again later."
                emailLayout.error = errorMessage
                passwordLayout.error = errorMessage
            }
        })
    }
}
