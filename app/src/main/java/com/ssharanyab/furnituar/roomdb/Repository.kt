package com.ssharanyab.furnituar.roomdb

import androidx.lifecycle.LiveData
import com.ssharanyab.furnituar.roomdb.Product
import com.ssharanyab.furnituar.roomdb.ProductDao

class Repository(productDao: ProductDao) {

    val readAllProduct:LiveData<List<Product>> = productDao.getAll()

}