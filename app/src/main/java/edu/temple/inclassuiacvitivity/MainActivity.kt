package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        val numberArray = Array<Int>(20) { i -> i * 5 + 5 }
        Log.i("Number Array", Arrays.toString(numberArray))
        /* TODO Step 3: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, numberArray)


        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected size from the spinner
                val selectedSize = numberArray[position]

                // Change the text size of the TextView to the selected size
                displayTextView.textSize = selectedSize.toFloat()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing if no item is selected
            }
        }
    }
}