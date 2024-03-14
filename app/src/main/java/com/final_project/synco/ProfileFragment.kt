package com.final_project.synco

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var updateProfileButton: Button
    private lateinit var logoutButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.name)
        emailEditText = view.findViewById(R.id.email)
        passwordEditText = view.findViewById(R.id.password)
        confirmPasswordEditText = view.findViewById(R.id.cpassword)
        updateProfileButton = view.findViewById(R.id.cancel)
        logoutButton = view.findViewById(R.id.logout)

        updateProfileButton.setOnClickListener { updateProfile() }
        logoutButton.setOnClickListener { logout() }
    }

    private fun updateProfile() {
        val name = nameEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val confirmPassword = confirmPasswordEditText.text.toString().trim()

        println("Name: $name")
        println("Email: $email")
        println("Password: $password")
        println("Confirm Password: $confirmPassword")

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }
        if (password != confirmPassword) {
            Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        val message = "Profile updated:\nName: $name\nEmail: $email\nPassword: $password\nConfirm Password: $confirmPassword"
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun logout() {
        val intent = Intent(requireContext(), Spage::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}