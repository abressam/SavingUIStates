package com.example.savinguistates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CounterActivity : AppCompatActivity() {

    /** Created a textView variable that is the type TextView.
     *  It's a private variable because only use in the CounterActivity class.
     *  lateinit only accept mutable variable (var) and is not allowed with null data types (cannot be TextView?)
     *  lateinit it's a promise to compiler that the value will be initialized in future.
     */
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Created counterText variable to save the instance with the key "key_count_num"
         *  used ?: for if the value was null, will print 0
         */
        val counterText = savedInstanceState?.getString("key_count_num") ?: "0"

        // Find the textView in the layout
        val number: TextView = findViewById(R.id.number_text)

        // Made the number variable equal to counterText to save the textView of number_text id
        number.text = counterText

        // Find the Button in the layout
        val plusButton: Button = findViewById(R.id.plus_button)

        // When the button is clicked, initialize the plusNumber function
        plusButton.setOnClickListener { plusNumber() }
    }

    /** This function will increase in one the textView
     *  and update the screen with the new value
     */
    private fun plusNumber() {

        /** The currentValue is a textView so need to set as text.
         *  Since we need an int variable, it's has to be convert to string first (because text cannot be int)
         *  and then convert the string to int. After that it's possible to make "currentValue + 1"
         *  Again, because text cannot be int, the result must be convert to string
        */
        val currentValue = textView.text.toString().toInt()
        val result = currentValue + 1
        textView.text = result.toString()
    }

    // This function will save the instance state
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Created a counterText variable with textView type and convert to string
        val counterText = textView.text.toString()

        // The outState will use the same key set at the beginning
        outState.putString("key_count_num", counterText)
    }

}

