package com.final_project.synco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AssignedFragment : Fragment() {
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf<Task>()
    private lateinit var recyclerViewAccepted: RecyclerView
    private lateinit var apiService: ApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_assigned, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiService = RetrofitClient.getService()
        recyclerViewAccepted = view.findViewById(R.id.recyclerView_accepted)
        recyclerViewAccepted.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(taskList)
        recyclerViewAccepted.adapter = taskAdapter

        getProject("1")
    }

    private fun getProject(projectId: String) {
        apiService.getProject(projectId).enqueue(object : Callback<ProjectData> {
            override fun onResponse(call: Call<ProjectData>, response: Response<ProjectData>) {
                if (response.isSuccessful) {
                    val projectData = response.body()
                    projectData?.let {
                        Toast.makeText(requireContext(), "Project Name: ${it.class_name}", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Failed to fetch project", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProjectData>, t: Throwable) {
                Toast.makeText(requireContext(), "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

