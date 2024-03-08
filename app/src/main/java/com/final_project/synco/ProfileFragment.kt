package com.final_project.synco

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ProfileFragment : Fragment() {
    lateinit var logout: Button
    lateinit var cancel: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        logout = view.findViewById(R.id.logout)
        cancel = view.findViewById(R.id.cancel)

        logout.setOnClickListener {
            val intent = Intent(requireActivity(), login_page::class.java)
            startActivity(intent)
        }

        cancel.setOnClickListener {
            val intent = Intent(requireActivity(), Spage::class.java)
            startActivity(intent)
        }

        return view
    }
}



