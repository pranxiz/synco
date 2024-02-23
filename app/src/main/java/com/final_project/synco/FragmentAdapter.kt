package com.final_project.synco

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
    override fun getItemCount(): Int {
       return 2
    }

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0 -> AssignedFragment()
          1 -> AcceptedFragment()
          2 -> DoneFragment()
          else -> AssignedFragment()
      }
    }
}