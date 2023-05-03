package com.example.breakingbadquotes.ui

import com.example.breakingbadquotes.data.entities.Quote

sealed class Response {
    data class OnSuccess(val listQuote: List<Quote>) : Response()
    data class OnError(val error: Throwable) : Response()
    object Loading : Response()
}