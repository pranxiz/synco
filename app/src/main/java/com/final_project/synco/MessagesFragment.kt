package com.final_project.synco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar

class MessagesFragment : Fragment() {

    private lateinit var messageList: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var cameraButton: ImageButton

    private lateinit var messageAdapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)
        messageList = view.findViewById(R.id.messageList)
        messageInput = view.findViewById(R.id.messageInput)
        sendButton = view.findViewById(R.id.sendButton)
        cameraButton = view.findViewById(R.id.cameraButton)

        messageAdapter = MessageAdapter()
        messageList.adapter = messageAdapter

        sendButton.setOnClickListener { sendMessage() }
        cameraButton.setOnClickListener { takePhoto() }

        return view
    }

    private fun sendMessage() {
        // Send message logic here
    }

    private fun takePhoto() {
        // Take photo logic here
    }

    class MessageAdapter : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

        private val messages = mutableListOf<Message>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent, false)
            return MessageViewHolder(view)
        }

        override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
            holder.bind(messages[position])
        }

        override fun getItemCount(): Int = messages.size

        fun addMessage(message: String, user: String, iconRes: Int) {
            val time = getCurrentTime()
            val newMessage = Message(message, time, user, iconRes)
            messages.add(newMessage)
            notifyItemInserted(messages.size - 1)
        }

        private fun getCurrentTime(): String {
            val now = Calendar.getInstance()
            val hour = now.get(Calendar.HOUR_OF_DAY)
            val minute = now.get(Calendar.MINUTE)
            return String.format("%02d:%02d", hour, minute)
        }

        inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val messageText: TextView = itemView.findViewById(R.id.messageText)
            private val messageTime: TextView = itemView.findViewById(R.id.messageTime)
            private val messageUser: TextView = itemView.findViewById(R.id.messageUser)
            private val messageIcon: ImageView = itemView.findViewById(R.id.messageIcon)

            fun bind(message: Message) {
                messageText.text = message.text
                messageTime.text = message.time
                messageUser.text = message.user
                messageIcon.setImageResource(message.iconRes)
            }
        }

        data class Message(
            val text: String,
            val time: String,
            val user: String,
            val iconRes: Int
        )
    }
}