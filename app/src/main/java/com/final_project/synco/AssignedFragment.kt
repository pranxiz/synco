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
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()
    private lateinit var recyclerViewAccepted: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        recyclerViewAccepted = view.findViewById(R.id.recyclerView_accepted)

        // Setup RecyclerView
        recyclerViewAccepted.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(taskList)
        recyclerViewAccepted.adapter = taskAdapter

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
            taskList.add(task)

            // Notify the adapter that the data set has changed
            taskAdapter.notifyDataSetChanged()

            show.visibility = View.GONE

            projectName.setText("")
            taskDescriptionEditText.setText("")
        }
    }
}