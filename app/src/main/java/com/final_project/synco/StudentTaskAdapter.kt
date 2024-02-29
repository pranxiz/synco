package com.final_project.synco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class
 StudentTaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<StudentTaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val classTextView: TextView = itemView.findViewById(R.id.SClassTextView)
        val subjectTextView: TextView = itemView.findViewById(R.id.SSubjectTextView)
        val projectDateTextView: TextView = itemView.findViewById(R.id.projectDateTextView)
        val submissionDateTextView: TextView = itemView.findViewById(R.id.submissionDateTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.taskDescriptionTextView)
        val acceptButton: Button = itemView.findViewById(R.id.acceptButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.studenttask_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = tasks[position]
        holder.classTextView.text = currentTask.className
        holder.subjectTextView.text = currentTask.subjectName
        holder.projectDateTextView.text = currentTask.projectDate
        holder.submissionDateTextView.text = currentTask.submissionDate
        holder.descriptionTextView.text = currentTask.description

        // Implement any click listeners or actions for the accept button here
        holder.acceptButton.setOnClickListener {
            // Add your action here
        }
    }

    override fun getItemCount() = tasks.size
}