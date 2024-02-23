package com.final_project.synco

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.final_project.synco.databinding.ActivitySpageBinding


class Spage : AppCompatActivity() {
    private lateinit var binding: ActivitySpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ChannelFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.bottom_channel -> replaceFragment(ChannelFragment())
                R.id.bottom_messages -> replaceFragment(MessagesFragment())
                R.id.bottom_profile -> replaceFragment(ProfileFragment())
                R.id.bottom_people -> replaceFragment(PeopleFragment())


                else ->{
            }
        }
        true
    }
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentmanager = supportFragmentManager
        val fragmentTransaction = fragmentmanager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}