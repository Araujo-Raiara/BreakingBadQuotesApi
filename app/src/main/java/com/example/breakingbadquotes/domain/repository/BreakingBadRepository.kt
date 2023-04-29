package com.example.breakingbadquotes.domain.repository

import com.example.breakingbadquotes.data.entities.Quote
import io.reactivex.rxjava3.core.Observable

interface BreakingBadRepository {
    fun getQuoteWithRxJava3() : Observable<List<Quote>>
    suspend fun getQuoteWithCoroutines() : List<Quote>
}