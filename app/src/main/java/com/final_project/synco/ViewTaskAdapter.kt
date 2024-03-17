package com.final_project.synco

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewTaskAdapter (val dataList: ArrayList<ViewTaskDC>): RecyclerView.Adapter<ViewTaskAdapter.ViewHolderClass>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_view_task, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.taskname.text = currentItem.task_name
        holder.descview.text = currentItem.description_view
    }
    class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView){
        val taskname : TextView = itemView.findViewById(R.id.task_name)
        val descview : TextView = itemView.findViewById(R.id.description_view)

    }
}