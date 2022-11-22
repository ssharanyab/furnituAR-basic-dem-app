package com.ssharanyab.furnituar.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ssharanyab.furnituar.AppDatabase
import com.ssharanyab.furnituar.Product
import com.ssharanyab.furnituar.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository
    val allProducts: LiveData<List<Product>>

    init {
        val productDao = AppDatabase.getDatabase(application).productDao()
        repository = Repository(productDao)
        allProducts = repository.readAllProduct
    }

     fun insert(product: Product){
         viewModelScope.launch (Dispatchers.IO){
             repository.insert(product)
         }
     }
}
