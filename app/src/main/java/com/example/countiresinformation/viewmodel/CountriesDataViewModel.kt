package com.example.countiresinformation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.countiresinformation.model.CountriesDataModel
import com.example.countiresinformation.repo.CountriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesDataViewModel@Inject constructor(private val repository: CountriesRepository) : ViewModel() {

     suspend fun fetchData() : ArrayList<CountriesDataModel> {
        return repository.fetchData()
    }
}