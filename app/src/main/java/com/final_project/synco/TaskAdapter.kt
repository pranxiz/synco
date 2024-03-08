package com.final_project.synco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TaskAdapter(private val taskList: MutableList<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectNameTextView: TextView = itemView.findViewById(R.id.projectNameTextView)
        val projectDateTextView: TextView = itemView.findViewById(R.id.projectDateTextView)
        val submissionDateTextView: TextView = itemView.findViewById(R.id.submissionDateTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.task_item,
            parent,
            false
        )
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = taskList[position]

        holder.projectNameTextView.text = currentItem.projectName
        holder.projectDateTextView.text = currentItem.projectDate
        holder.submissionDateTextView.text = currentItem.submissionDate
        holder.descriptionTextView.text = currentItem.description
    }

    override fun getItemCount() = taskList.size
}