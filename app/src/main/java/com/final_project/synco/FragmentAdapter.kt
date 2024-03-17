package com.final_project.synco

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
        // Return the total number of fragments
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AssignedFragment() // Replace with the actual fragment for "Project"
            1 -> AcceptedFragment()    // Replace with the actual fragment for "Task"
            2 -> DoneFragment()    // Replace with the actual fragment for "Done"
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
