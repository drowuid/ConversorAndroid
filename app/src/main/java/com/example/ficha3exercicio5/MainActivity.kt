package com.example.linearlayouttest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.linearlayouttest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Dolares Conversion
        binding.buttonDolares.setOnClickListener {
            val euros = binding.editMoeda.text.toString().toDoubleOrNull()

            if (euros != null) {
                val dolares = (euros * 0.8).toInt() // Convert to int and display the result
                binding.textResultado.text = "$dolares $" // Add the dollar symbol
            } else {
                Toast.makeText(this, "ERROR: Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        // Reais Conversion
        binding.buttonReais.setOnClickListener {
            val euros = binding.editMoeda.text.toString().toDoubleOrNull()

            if (euros != null) {
                val reais = (euros * 6.4).toInt() // Convert to int and display the result
                binding.textResultado.text = "$reais R$" // Add the reais symbol
            } else {
                Toast.makeText(this, "ERROR: Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        // Francos Conversion
        binding.buttonFrancos.setOnClickListener {
            val euros = binding.editMoeda.text.toString().toDoubleOrNull()

            if (euros != null) {
                val francos = (euros * 0.98).toInt() // Convert to int and display the result
                binding.textResultado.text = "$francos CHF" // Add the franc symbol
            } else {
                Toast.makeText(this, "ERROR: Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

