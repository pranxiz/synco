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

        recyclerViewAccepted = view.findViewById(R.id.recyclerView_accepted)

        recyclerViewAccepted.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(taskList)
        recyclerViewAccepted.adapter = taskAdapter



        // Notify the adapter that the data set has changed
        taskAdapter.notifyDataSetChanged()
    }
}