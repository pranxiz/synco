package com.final_project.synco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class PopUpFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pop_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskname = view.findViewById<EditText>(R.id.task_name)
        val description = view.findViewById<EditText>(R.id.description)
        val subbutton = view.findViewById<Button>(R.id.submitButton)

        taskname.setOnClickListener {
            val value = taskname.text.toString()
            if (value.isEmpty()) {
                Toast.makeText(context, "Please fill the Task Name", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, value, Toast.LENGTH_LONG).show()

            }
            description.setOnClickListener {
                val value = description.text.toString()
                if (value.isEmpty()) {
                    Toast.makeText(context, "Please fill the Description", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, value, Toast.LENGTH_LONG).show()

                }
            }
        }

    }
}
