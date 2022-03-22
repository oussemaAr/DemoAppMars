package com.digitals.pokemonapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val showToast = findViewById<Button>(R.id.show_toast_button)
        val incrementCount = findViewById<Button>(R.id.increment_count_button)
        val countDisplay = findViewById<TextView>(R.id.count_display_text_view)

        showToast.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
        }
        showToast.setOnLongClickListener {
            Snackbar.make(it, "Hello snackBar", Snackbar.LENGTH_LONG).show()
            true
        }

        incrementCount.setOnClickListener {
            var oldValue = countDisplay.intValue()
            oldValue++
            countDisplay.text = oldValue.toString()
            when (oldValue) {
                in 0..5 -> countDisplay.setTextColor(getColor(R.color.black))
                in 5..10 -> countDisplay.setTextColor(getColor(R.color.purple_700))
            }
        }

        countDisplay.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayCountActivity::class.java)
            intent.putExtra(COUNT_EXTRA, countDisplay.intValue())
            startActivity(intent)
        }
    }
}

const val COUNT_EXTRA = "count"
