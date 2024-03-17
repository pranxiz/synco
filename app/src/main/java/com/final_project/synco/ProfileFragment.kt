package com.final_project.synco

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find views
        val nameTextView: TextView = view.findViewById(R.id.name)
        val emailTextView: TextView = view.findViewById(R.id.email)
        val logoutButton: Button = view.findViewById(R.id.logout)

        nameTextView.text = "nameValue"
        emailTextView.text = "emailValue"

        logoutButton.setOnClickListener {
            logout()
        }
    }
    private fun logout() {
        val intent = Intent(requireContext(), login_page::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}