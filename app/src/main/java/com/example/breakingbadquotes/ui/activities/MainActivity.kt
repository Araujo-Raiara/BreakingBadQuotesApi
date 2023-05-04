package com.example.breakingbadquotes.ui.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.breakingbadquotes.R
import com.example.breakingbadquotes.data.entities.Quote
import com.example.breakingbadquotes.databinding.ActivityMainBinding
import com.example.breakingbadquotes.ui.Response
import com.example.breakingbadquotes.ui.viewmodel.BreakingBadViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val breakingBadViewModel: BreakingBadViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            btnLoadRx.setOnClickListener {
                hideViews()
                breakingBadViewModel.getQuoteWithRxJava3()

            }
            btnLoadCoroutines.setOnClickListener {
                hideViews()
                breakingBadViewModel.getQuoteWithCoroutines()
            }
        }
    }

    private fun setupObservers() {
        breakingBadViewModel.listQuote.observe(this) { response ->
            when (response) {
                is Response.OnError -> handleError(response.error)
                is Response.OnSuccess -> handleSuccess(response.listQuote)
                is Response.Loading -> handleLoading()
            }
        }
    }

    private fun handleError(throwable: Throwable) {
        hideProgressBar()
        Log.e(TAG, "Error loading quotes", throwable)
        val errorMessage = "Não foi possível carregar os dados, tente novamente."
        Toast.makeText(
            this,
            errorMessage,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun handleSuccess(quotes: List<Quote>) {
        hideProgressBar()
        binding.tvQuote.text = getString(R.string.text_quote, quotes.first().quote)
        binding.tvAuthor.text = quotes.first().author
    }

    private fun handleLoading() {
        binding.pbLoading.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.pbLoading.visibility = View.GONE
    }

    private fun hideViews() {
        binding.tvStart.visibility = View.GONE
    }
}