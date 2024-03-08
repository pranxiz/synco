package com.final_project.synco

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class SplashScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val videoView = findViewById<VideoView>(R.id.videoViewSplash)
        val videoPath ="android.resource;//"+ packageName + "/" + R.raw.splashh_video

        val videoUri  = Uri.parse(videoPath)
        videoView.start()

        videoView.setOnCompletionListener {
            val intent = Intent(this, login_page::class.java)
            startActivity(intent)
            finish()
        }
    }
}