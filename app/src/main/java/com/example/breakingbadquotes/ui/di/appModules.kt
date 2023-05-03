package com.example.breakingbadquotes.ui.di

import com.example.breakingbadquotes.core.Constants.BASE_URL
import com.example.breakingbadquotes.data.remotedatabase.BreakingBadService
import com.example.breakingbadquotes.data.repository.BreakingBadRepositoryImpl
import com.example.breakingbadquotes.domain.repository.BreakingBadRepository
import com.example.breakingbadquotes.ui.viewmodel.BreakingBadViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val baseNetwork = module {
    single<BreakingBadService> {
        get<Retrofit>().create(BreakingBadService::class.java)
    }
    single<Retrofit> {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}

val baseRepository = module {
    single<BreakingBadRepository> {
        BreakingBadRepositoryImpl(get())
    }
}

val baseViewModel = module {
    viewModel { BreakingBadViewModel(get()) }
}