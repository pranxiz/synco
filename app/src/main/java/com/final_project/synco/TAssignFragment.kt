package com.final_project.synco
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.final_project.synco.R
import java.util.Calendar

class TAssignFragment : Fragment() {
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_assign, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addButton = view.findViewById<Button>(R.id.addButton)
        val show = view.findViewById<LinearLayout>(R.id.show)
        val SClassSpinner = view.findViewById<Spinner>(R.id.SClassSpinner)
        val SSubjectSpinner = view.findViewById<Spinner>(R.id.SSubjectSpinner)
        val projectDatePicker = view.findViewById<DatePicker>(R.id.projectDatePicker)
        val submissionDatePicker = view.findViewById<DatePicker>(R.id.submissionDatePicker)
        val taskDescriptionEditText = view.findViewById<EditText>(R.id.taskDescriptionEditText)
        val postButton = view.findViewById<Button>(R.id.postButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(taskList)
        recyclerView.adapter = taskAdapter

        addButton.setOnClickListener {
            if (show.visibility == View.GONE) {
                show.visibility = View.VISIBLE
            } else {
                show.visibility = View.GONE
            }
        }

        postButton.setOnClickListener {
            val className = SClassSpinner.selectedItem.toString()
            val subjectName = SSubjectSpinner.selectedItem.toString()
            val projectDate =
                "${projectDatePicker.dayOfMonth}/${projectDatePicker.month}/${projectDatePicker.year}"
            val submissionDate =
                "${submissionDatePicker.dayOfMonth}/${submissionDatePicker.month}/${submissionDatePicker.year}"
            val description = taskDescriptionEditText.text.toString()

            // Create a new task
            val task = Task(className, subjectName, projectDate, submissionDate, description)

            // Add the task to the list
            taskList.add(task)

            // Notify the adapter that the data set has changed
            taskAdapter.notifyDataSetChanged()
        }
    }
}