package com.final_project.synco
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.final_project.synco.databinding.ActivitySignupPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class signup_page : AppCompatActivity() {
    private lateinit var binding: ActivitySignupPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TextView.setOnClickListener {
            startActivity(Intent(this, login_page::class.java))
        }

        binding.signupButton.setOnClickListener {
            val name= binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.cpassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    val user = User(
                        name = name,
                        email = email,
                        password = password,
                    )
                    registerUser(user)
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(user: User) {
        binding.signupButton.isEnabled = false
        val apiService = RetrofitClient.getService()
        val call = apiService.register(user)

        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                binding.signupButton.isEnabled = true
                if (response.isSuccessful) {
                    Toast.makeText(this@signup_page, "Registration successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@signup_page, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                binding.signupButton.isEnabled = true
                Toast.makeText(this@signup_page, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}