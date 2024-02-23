package com.final_project.synco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PeopleFragment : Fragment() {
    private lateinit var members: List<Member>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_people, container, false)

        // Replace this with actual data source, such as a database or API
        members = listOf(

        )

        val memberAdapter = MemberAdapter(members)
        view.findViewById<RecyclerView>(R.id.memberList).adapter = memberAdapter

        return view
    }
}

data class Member(val name: String, val profilePicResId: Int)

class MemberAdapter(private val members: List<Member>) :
    RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.member_item, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(members[position])
    }

    override fun getItemCount(): Int = members.size

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(member: Member) {
            itemView.findViewById<ImageView>(R.id.pfp).setImageResource(member.profilePicResId)
            itemView.findViewById<TextView>(R.id.uname).text = member.name
        }
    }
}