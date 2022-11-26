package com.ssharanyab.furnituar.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ssharanyab.furnituar.roomdb.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product_table")
    fun getAll():LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)

    @Query("DELETE FROM product_table")
    fun deleteAll()

    @Query("SELECT * FROM product_table WHERE name = :name")
    fun isDataExist(name: String?): Boolean
//    @Query("UPDATE product_table SET name=:name,last_name=:lastName WHERE name LIKE:name")
//    fun update()

}