package com.final_project.synco

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class AssignedFragment : Fragment() {
    private lateinit var noteContent: EditText
    private lateinit var postButton: Button
    private lateinit var addButton: Button
    private lateinit var addTitle: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_assigned, container, false)



        addTitle = view.findViewById(R.id.addTitle)
        noteContent = view.findViewById(R.id.noteContent)
        postButton = view.findViewById(R.id.postButton)
        addButton = view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            noteContent.visibility = View.VISIBLE
            postButton.visibility = View.VISIBLE
            addTitle.visibility = View.VISIBLE
        }

        return view
    }
}