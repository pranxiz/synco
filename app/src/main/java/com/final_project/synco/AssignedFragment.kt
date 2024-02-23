package com.final_project.synco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import java.util.Calendar

class AssignedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_assigned, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton = view.findViewById<Button>(R.id.addButton)
        val show = view.findViewById<LinearLayout>(R.id.show)
        val SClassSpinner = view.findViewById<Spinner>(R.id.SClassSpinner)
        val SSubjectSpinner = view.findViewById<Spinner>(R.id.SSubjectSpinner)
        val projectDatePicker = view.findViewById<DatePicker>(R.id.projectDatePicker)
        val submissionDatePicker = view.findViewById<DatePicker>(R.id.submissionDatePicker)

        addButton.setOnClickListener {
            if (show.visibility == View.GONE) {
                show.visibility = View.VISIBLE
            } else {
                show.visibility = View.GONE
            }
        }

        // Initialize spinners
        val classAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.classes,
            android.R.layout.simple_spinner_item
        )
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        SClassSpinner.adapter = classAdapter

        val subjectAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.subjects,
            android.R.layout.simple_spinner_item
        )
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        SSubjectSpinner.adapter = subjectAdapter

        // Initialize date pickers
        projectDatePicker.init(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), null)
        submissionDatePicker.init(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), null)
    }
}