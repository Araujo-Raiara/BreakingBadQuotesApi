package com.example.breakingbadquotes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadquotes.domain.repository.BreakingBadRepository
import com.example.breakingbadquotes.ui.Response
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.coroutines.launch

class BreakingBadViewModel(
    private val breakingBadRepository: BreakingBadRepository
) : ViewModel() {
    private val _listQuote: MutableLiveData<Response> = MutableLiveData()
    val listQuote: LiveData<Response> get() = _listQuote

    private lateinit var disposable: Disposable

    fun getQuoteWithRxJava3() {
        disposable = breakingBadRepository.getQuoteWithRxJava3()
            .subscribeBy(
                onSuccess = { _listQuote.postValue(Response.OnSuccess(it)) },
                onError = { _listQuote.postValue(Response.OnError(it)) }
            )
    }

    fun getQuoteWithCoroutines() {
        viewModelScope.launch {
            try {
                val response = breakingBadRepository.getQuoteWithCoroutines()
                _listQuote.postValue(Response.OnSuccess(response))
            } catch (e: Exception) {
                _listQuote.postValue(Response.OnError(e))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}