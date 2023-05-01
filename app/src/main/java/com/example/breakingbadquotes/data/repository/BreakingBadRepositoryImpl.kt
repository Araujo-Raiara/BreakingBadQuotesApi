package com.example.breakingbadquotes.data.repository

import com.example.breakingbadquotes.data.entities.Quote
import com.example.breakingbadquotes.data.remotedatabase.BreakingBadService
import com.example.breakingbadquotes.domain.repository.BreakingBadRepository
import io.reactivex.rxjava3.core.Single

class BreakingBadRepositoryImpl(
    private val breakingBadService: BreakingBadService
) : BreakingBadRepository {
    override fun getQuoteWithRxJava3(): Single<List<Quote>> {
        return breakingBadService.getQuotesWithRxJava3()
    }

    override suspend fun getQuoteWithCoroutines(): List<Quote> {
        return breakingBadService.getQuotesWithCoroutines()
    }
}