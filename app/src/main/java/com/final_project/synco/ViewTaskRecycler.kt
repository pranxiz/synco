package com.final_project.synco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewTaskRecycler : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewTaskAdapter: ViewTaskAdapter
    private val dataList = ArrayList<ViewTaskDC>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_view_task_recycler, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView_task)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewTaskAdapter = ViewTaskAdapter(dataList)
        recyclerView.adapter = viewTaskAdapter

        return rootView

    }
}
