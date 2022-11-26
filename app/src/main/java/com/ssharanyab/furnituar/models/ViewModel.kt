package com.ssharanyab.furnituar.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ssharanyab.furnituar.roomdb.AppDatabase
import com.ssharanyab.furnituar.roomdb.Product
import com.ssharanyab.furnituar.roomdb.Repository

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    val allProducts: LiveData<List<Product>>

    init {
        val productDao = AppDatabase.getDatabase(application).productDao()
        repository = Repository(productDao)
        allProducts = repository.readAllProduct
    }

}
