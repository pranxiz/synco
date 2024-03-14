package com.final_project.synco
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AssignedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_assigned, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton = view.findViewById<Button>(R.id.addButton)
        val show = view.findViewById<LinearLayout>(R.id.show)
        val projectName = view.findViewById<EditText>(R.id.projectName)
        val projectDatePicker = view.findViewById<DatePicker>(R.id.projectDatePicker)
        val submissionDatePicker = view.findViewById<DatePicker>(R.id.submissionDatePicker)
        val taskDescriptionEditText = view.findViewById<EditText>(R.id.taskDescriptionEditText)
        val postButton = view.findViewById<Button>(R.id.postButton)

        addButton.setOnClickListener {
            if (show.visibility == View.GONE) {
                show.visibility = View.VISIBLE
            } else {
                show.visibility = View.GONE
            }
        }

        postButton.setOnClickListener {
            val projectDate =
                "${projectDatePicker.dayOfMonth}/${projectDatePicker.month}/${projectDatePicker.year}"
            val submissionDate =
                "${submissionDatePicker.dayOfMonth}/${submissionDatePicker.month}/${submissionDatePicker.year}"
            val description = taskDescriptionEditText.text.toString()
            val projectNameText = projectName.text.toString()

            // Create a new task
            val task = Task(projectNameText, projectDate, submissionDate, description)

            // Add the task to the list
            // (You might want to handle the task list differently now that the RecyclerView is in another fragment)
            // taskList.add(task)

            // Notify the adapter that the data set has changed
            // taskAdapter.notifyDataSetChanged()

            show.visibility = View.GONE

            projectName.setText("")
            taskDescriptionEditText.setText("")
        }
    }
}