package com.dicoding.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detail : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvDescription2: TextView
    private lateinit var imgPhoto: ImageView
    private lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvName = findViewById(R.id.tv_name)
        tvDescription = findViewById(R.id.tv_description)
        tvDescription2 = findViewById(R.id.tv_description2)
        imgPhoto = findViewById(R.id.img_photo)
        shareButton = findViewById(R.id.action_share)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val description2 = intent.getStringExtra(EXTRA_DESCRIPTION2)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        tvName.text = name
        tvDescription.text = description
        tvDescription2.text = description2
        imgPhoto.setImageResource(photo)

        shareButton.setOnClickListener {
            shareContent(name, description)
        }
    }

    private fun shareContent(name: String?, description: String?) {
        val shareText = "$name\n$description"
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        if (shareIntent.resolveActivity(packageManager) != null) {
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_DESCRIPTION2 = "extra_description2"
        const val EXTRA_PHOTO = "extra_photo"
    }
}
