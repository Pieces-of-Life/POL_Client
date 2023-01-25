package com.example.pol1.Acitivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pol1.databinding.ActivityChatSendBinding

class ChatSendActivity: AppCompatActivity() {
    private lateinit var viewBinding: ActivityChatSendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityChatSendBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


    }

}