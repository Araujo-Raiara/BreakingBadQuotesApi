package com.example.breakingbadquotes.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.breakingbadquotes.databinding.ActivityMainBinding
import com.example.breakingbadquotes.ui.viewmodel.BreakingBadViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val breakingBadViewModel: BreakingBadViewModel by viewModel()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}