package com.example.breakingbadquotes.data.remotedatabase

import com.example.breakingbadquotes.data.entities.Quote
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface BreakingBadService {
    @GET("v1/quotes")
    fun getQuotesWithRxJava3(): Single<List<Quote>>

    @GET("v1/quotes")
    suspend fun getQuotesWithCoroutines(): List<Quote>
}