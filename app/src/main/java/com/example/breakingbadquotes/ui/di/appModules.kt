package com.example.breakingbadquotes.ui.di

import com.example.breakingbadquotes.core.Constants.BASE_URL
import com.example.breakingbadquotes.data.remotedatabase.BreakingBadService
import com.example.breakingbadquotes.data.repository.BreakingBadRepositoryImpl
import com.example.breakingbadquotes.domain.repository.BreakingBadRepository
import com.example.breakingbadquotes.ui.viewmodel.BreakingBadViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseNetwork = module {
    single<BreakingBadService> {
        get<Retrofit>().create(BreakingBadService::class.java)
    }
    single<Retrofit> {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
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