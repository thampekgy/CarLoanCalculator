package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateReplacement()
        }

    }


    private fun calculateReplacement()
    {
        //Todo get inputs and show outputs

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))  //show the error msg from string xml file.
            return
        }

        val nf = NumberFormat.getCurrencyInstance(Locale.UK)



        val carPrice = editTextCarPrice.text.toString().toInt() // Convert data from string to integer
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val load = carPrice-downPayment

        textViewLoad.setText(getString(R.string.load) + nf + "${load}")  // Load :2

        val interestRate = editTextInteresrRate.text.toString().toFloat()
        val loanPeriod = editTextLoadPeriod.text.toString().toInt()
        val interest = load*interestRate*loanPeriod

        textViewInterest.setText(getString(R.string.interest) + "${interest}")


        val monthlyReplacement = (load + interest)/loanPeriod/12

        textViewmonthlyReplacment.setText(getString(R.string.monthly_replacement) + "${monthlyReplacement}")




    }

    fun reset (view: View){
        //Todo get inputs and show outputs


    }


}
