package com.dicoding.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInstagram = findViewById<Button>(R.id.btn_instagram)
        val btnLinkedIn = findViewById<Button>(R.id.btn_linkedin)
        val btnGitHub = findViewById<Button>(R.id.btn_github)

        btnInstagram.setOnClickListener {
            openUrl("https://instagram.com/dionp3")
        }

        btnLinkedIn.setOnClickListener {
            openUrl("https://linkedin.com/in/dionp3")
        }

        btnGitHub.setOnClickListener {
            openUrl("https://github.com/dionp3")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
