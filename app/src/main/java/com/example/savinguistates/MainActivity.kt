package com.example.savinguistates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar_custom))

        val counterText = savedInstanceState?.getString("key_count_num") ?: "0"

        val number = findViewById<TextView>(R.id.number_text)
        number.text = counterText

        val plusButton: Button = findViewById(R.id.plus_button)
        plusButton.setOnClickListener { plusNumber() }
    }

    private fun plusNumber() {
        val currentValue = textView.text.toString().toInt()
        val result = currentValue + 1
        textView.text = result.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val counterText = textView.text.toString()

        outState.putString("key_count_num", counterText)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(this, "Shared clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

}

