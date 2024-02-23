package com.final_project.synco

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Set a click listener for the edit profile button
        view.findViewById<Button>(R.id.edile).setOnClickListener {

            val intent = Intent(requireActivity(), editProfile::class.java)
            startActivity(intent)
        }
        return view
    }

}