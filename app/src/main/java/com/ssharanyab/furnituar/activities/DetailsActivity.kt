package com.ssharanyab.furnituar.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ssharanyab.furnituar.roomdb.AppDatabase
import com.ssharanyab.furnituar.roomdb.Product
import com.ssharanyab.furnituar.models.Model
import com.ssharanyab.furnituar.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {
    private lateinit var appDatabase: AppDatabase
    lateinit var btnAddToCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
       // setContentView(binding.root)
        appDatabase = AppDatabase.getDatabase(this)
        setContentView(R.layout.activity_details)

        val modelItems : Model = intent.getSerializableExtra("data") as Model

        val imageName = findViewById<TextView>(R.id.imageName)
        imageName.text = modelItems.name
        val description = findViewById<TextView>(R.id.imageDesc)
        description.text = modelItems.desc
        val price = findViewById<TextView>(R.id.price)
        price.text = modelItems.price
        description.text = modelItems.desc
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(modelItems.image!!)


        btnAddToCart = findViewById(R.id.addToCart)
        btnAddToCart.setOnClickListener{
            writeData(imageName.text.toString(),price.text.toString())
        }
    }
    private fun writeData(name:String, price:String){
        if( name.isNotEmpty()&& price.isNotEmpty()){
            val product = Product(
                null,
                name,
                price,
            )
            GlobalScope.launch(Dispatchers.IO){
                appDatabase.productDao().insert(product)
            }

            Toast.makeText(this@DetailsActivity,"Added to Cart", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this@DetailsActivity,"Fill Details", Toast.LENGTH_SHORT).show()
        }

    }
}