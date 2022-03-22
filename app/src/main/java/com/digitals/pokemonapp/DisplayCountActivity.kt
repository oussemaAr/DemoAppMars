package com.digitals.pokemonapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.digitals.pokemonapp.databinding.ActivityDisplayCountBinding

class DisplayCountActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDisplayCountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayCountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.callSomeoneButton.setOnClickListener {
            val uri = Uri.parse("tel:8005551234")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        binding.visitLinkButton.setOnClickListener{
            val uri = Uri.parse("https://youtube.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        displayCount()
    }

    private fun displayCount() {
        val count = intent.getIntExtra(COUNT_EXTRA, 0)
        binding.displayCountTextView.text = count.toString()
    }
}