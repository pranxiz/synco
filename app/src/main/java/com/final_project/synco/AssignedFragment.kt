package com.final_project.synco

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.final_project.synco.databinding.FragmentAssignedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class AssignedFragment : Fragment() {
    private var _binding: FragmentAssignedBinding? = null
    private val binding get() = _binding!!
    private lateinit var apiService: ApiService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAssignedBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiService = RetrofitClient.getService()

        val addButton = view.findViewById<Button>(R.id.addButton)
        val showLayout = view.findViewById<LinearLayout>(R.id.show)
        val projectNameEditText = view.findViewById<EditText>(R.id.class_name)
        val projectDatePicker = view.findViewById<DatePicker>(R.id.project_date)
        val submissionDatePicker = view.findViewById<DatePicker>(R.id.submission_date)
        val descriptionEditText = view.findViewById<EditText>(R.id.description)
        val postButton = view.findViewById<Button>(R.id.postButton)

        addButton.setOnClickListener {
            showLayout.visibility = if (showLayout.visibility == View.GONE) View.VISIBLE else View.GONE
        }

        postButton.setOnClickListener {
            val projectDate = LocalDate.of(projectDatePicker.year, projectDatePicker.month + 1, projectDatePicker.dayOfMonth)
            val submissionDate = LocalDate.of(submissionDatePicker.year, submissionDatePicker.month + 1, submissionDatePicker.dayOfMonth)
            val description = descriptionEditText.text.toString()
            val projectName = projectNameEditText.text.toString()

            val userId = getUserId()
            if (userId == -1L) {
                Toast.makeText(requireContext(), "User ID not found. Please login again.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val projectData = ProjectData(
                class_name = projectName,
                project_date = projectDate.format(DateTimeFormatter.ISO_LOCAL_DATE),
                submission_date = submissionDate.format(DateTimeFormatter.ISO_LOCAL_DATE),
                description = description,
                created_by = userId // Using the fetched user ID
            )

            createProject(projectData)

            showLayout.visibility = View.GONE
            projectNameEditText.setText("")
            descriptionEditText.setText("")
        }

        // Fetch project data by ID
        val id: Long = arguments?.getLong("id", -1L) ?: -1L
        if (id != -1L) {
            getProjectById(id)
        } else {
            Toast.makeText(requireContext(), "Invalid project ID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserId(): Long {
        val sharedPreferences = requireActivity().getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getLong("userId", -1L) // Assuming -1 as default (invalid) value
    }

    private fun createProject(projectData: ProjectData) {
        apiService.createProject(projectData).enqueue(object : Callback<ProjectData> {
            override fun onResponse(call: Call<ProjectData>, response: Response<ProjectData>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Project created successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Failed to create project", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProjectData>, t: Throwable) {
                Toast.makeText(requireContext(), "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getProjectById(id: Long) {
        apiService.getProjectById(id).enqueue(object : Callback<GetProjectData> {
            override fun onResponse(call: Call<GetProjectData>, response: Response<GetProjectData>) {
                if (response.isSuccessful) {
                    val project = response.body()
                    // Handle the project data here
                } else {
                    Toast.makeText(requireContext(), "Failed to retrieve project", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<GetProjectData>, t: Throwable) {
                Toast.makeText(requireContext(), "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
