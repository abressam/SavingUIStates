package com.example.savinguistates

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CounterFragment : Fragment(R.layout.fragment_counter) {

    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_custom)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)

        val counterText = savedInstanceState?.getString("key_counter") ?: "0"
        textView = view.findViewById(R.id.number_text)
        textView.text = counterText

        view.findViewById<Button>(R.id.plus_button).setOnClickListener {
            val currentValue = textView.text.toString().toInt()
            val result = currentValue + 1
            textView.text = result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val counterText = textView.text.toString()
        outState.putString("key_counter", counterText)
    }

    override fun onCreateOptionsMenu (menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_share -> {
                Toast.makeText(activity, "Shared clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(activity, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
}