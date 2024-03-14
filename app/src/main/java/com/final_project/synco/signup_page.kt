package com.final_project.synco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.final_project.synco.databinding.ActivitySignupPageBinding
import retrofit2.Call

class signup_page : AppCompatActivity() {
    private lateinit var binding: ActivitySignupPageBinding

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var cpassword: EditText
    lateinit var signupButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TextView.setOnClickListener {
            val intent = Intent(this, login_page::class.java)
            startActivity(intent)
        }

        binding.signupButton.setOnClickListener {
            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()
            val confirmPass = binding.cpassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    val user = User(null, email, pass, confirmPass)
                    val call = RetrofitClient.getService().register(user)
                    call.enqueue(object : retrofit2.Callback<User> {
                        override fun onResponse(call: Call<User>, response: retrofit2.Response<User>) {
                            // Handle registration success
                            if (response.isSuccessful) {
                                Toast.makeText(this@signup_page, "Registration successful", Toast.LENGTH_SHORT).show()
                            } else {
                                // Handle registration failure
                                Toast.makeText(this@signup_page, "Registration failed", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            // Handle network errors
                            Toast.makeText(this@signup_page, "Network error", Toast.LENGTH_SHORT).show()
                        }
                    })
                } else {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}