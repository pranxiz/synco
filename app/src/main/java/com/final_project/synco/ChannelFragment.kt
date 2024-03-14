package com.final_project.synco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ChannelFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_channel, container, false)


        val fViewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        val fTabLayout: TabLayout = view.findViewById(R.id.tabLayout)


        fViewPager.adapter = FragmentAdapter(this)
        TabLayoutMediator(fTabLayout, fViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Project"
                1 -> tab.text = "Task"
                2 -> tab.text = "Done"
            }
        }.attach()


        return view
    }

    private inner class FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AssignedFragment()
                1 -> AcceptedFragment()
                2 -> DoneFragment()
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }
    }
}