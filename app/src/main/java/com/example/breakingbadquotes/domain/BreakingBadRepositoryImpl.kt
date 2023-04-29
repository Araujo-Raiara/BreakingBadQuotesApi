package com.example.breakingbadquotes.domain

import com.example.breakingbadquotes.data.remotedatabase.BreakingBadService
import com.example.breakingbadquotes.data.entities.Quote
import com.example.breakingbadquotes.data.repository.BreakingBadRepository
import io.reactivex.rxjava3.core.Observable

class BreakingBadRepositoryImpl(
    private val breakingBadService: BreakingBadService
) : BreakingBadRepository{
    override fun getQuoteWithRxJava3(): Observable<List<Quote>> {
        return breakingBadService.getQuotesWithRxJava3()
    }

    override suspend fun getQuoteWithCoroutines(): List<Quote> {
        return breakingBadService.getQuotesWithCoroutines()
    }

}