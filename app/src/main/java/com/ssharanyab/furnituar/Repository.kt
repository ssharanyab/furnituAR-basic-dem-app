package com.ssharanyab.furnituar

import androidx.lifecycle.LiveData

class Repository(private val productDao: ProductDao ) {

    suspend fun insert(product: Product) {
        productDao.insert(product)
    }

    val readAllProduct:LiveData<List<Product>> = productDao.getAll()

}