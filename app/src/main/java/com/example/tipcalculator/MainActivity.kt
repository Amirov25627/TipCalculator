package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMinus.setOnClickListener { tipDecrease() } // button - on tip window
        binding.buttonPlus.setOnClickListener { tipIncrease() }  // button + on tip window
        binding.buttonMinus2.setOnClickListener { numDecrease() }// button - on num window
        binding.buttonPlus2.setOnClickListener { numIncrease() } // button + on num window

        binding.billEdit.doOnTextChanged { _, _, _, _ ->
            counter()
        }
    }

    private fun tipDecrease(){
        if(binding.tipEdit.text.toString().toIntOrNull() != null){
              val x = binding.tipEdit.text.toString().toInt()
              if (x > 0) {val x2 = x-1
              binding.tipEdit.setText(x2.toString())} else {
                  val x2 = 0
                  binding.tipEdit.setText(x2.toString())
              }
        }  else {val x2 = 0
            binding.tipEdit.setText(x2.toString())}
        counter()
    }

    private fun tipIncrease(){
        if(binding.tipEdit.text.toString().toIntOrNull() != null){
            val x = binding.tipEdit.text.toString().toInt()
            if (x < 100) {val x2 = x+1
                binding.tipEdit.setText(x2.toString())} else {
                val x2 = 100
                binding.tipEdit.setText(x2.toString())
            }
        }  else {val x2 = 0
            binding.tipEdit.setText(x2.toString())}
        counter()
    }

    private fun numDecrease(){
        if(binding.numEdit.text.toString().toIntOrNull() != null){
            val x = binding.numEdit.text.toString().toInt()
            if (x > 1) {val x2 = x-1
                binding.numEdit.setText(x2.toString())} else {
                val x2 = 1
                binding.numEdit.setText(x2.toString())
            }
        }  else {val x2 = 1
            binding.numEdit.setText(x2.toString())}
        counter()
    }

    private fun numIncrease(){
        if(binding.numEdit.text.toString().toIntOrNull() != null){
            val x = binding.numEdit.text.toString().toInt()
            if (x < 99999) {val x2 = x+1
                binding.numEdit.setText(x2.toString())} else {
                val x2 = 99999
                binding.numEdit.setText(x2.toString())
            }
        }  else {val x2 = 99999
            binding.numEdit.setText(x2.toString())}
        counter()
    }

private fun counter(){
    if (binding.billEdit.getText().toString().toIntOrNull() != null) {
        val x = binding.billEdit.getText().toString().toInt()
        val percent = binding.tipEdit.getText().toString().toInt()
        val number = binding.numEdit.getText().toString().toInt()
        val tip =  x * percent / 100
        val total = (tip + x) * number
        binding.tipResult.setText(tip.toDouble().toString())
        binding.totalResult.setText(total.toInt().toString())
    }
    else {
        val x2 = 0

        binding.tipResult.setText(x2.toString())
        binding.totalResult.setText(x2.toString())
    }
}



    }
