package com.ssharanyab.furnituar.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssharanyab.furnituar.AppDatabase
import com.ssharanyab.furnituar.R
import com.ssharanyab.furnituar.adaptor.AdapterCart
import com.ssharanyab.furnituar.models.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase
    lateinit var btnCheckout : Button
    lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ViewModel
    lateinit var cartEmptyText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val adapter = AdapterCart()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(this)

        appDatabase = AppDatabase.getDatabase(this)

        btnCheckout = findViewById(R.id.btnCheckout)
        cartEmptyText = findViewById(R.id.cartEmptyText)

        btnCheckout.setOnClickListener{
            GlobalScope.launch {
                appDatabase.productDao().deleteAll()
            }
            Toast.makeText(this@CartActivity,"Checkout Sucessful",Toast.LENGTH_LONG).show()
            cartEmptyText.visibility = TextView.VISIBLE
            recyclerView.visibility = RecyclerView.GONE
        }
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.allProducts.observe(this) { product ->
            adapter.setData(product)
        }

        // Database display all records
//        GlobalScope.launch {
//            val allProducts = appDatabase.productDao().getAll()
//            for (product in allProducts){
//                println(product)
//            }
//        }

//        GlobalScope.launch {
//            val products = appDatabase.productDao().getAll()
//        }


    }
}