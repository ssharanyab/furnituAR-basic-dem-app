package com.ssharanyab.furnituar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import com.ssharanyab.furnituar.activities.CartActivity
import com.ssharanyab.furnituar.activities.DetailsActivity
import com.ssharanyab.furnituar.adaptor.CustomAdaptor
import com.ssharanyab.furnituar.models.Model

class MainActivity : AppCompatActivity() {
    lateinit var btnCart : Button
    var modelList= ArrayList<Model>()
    var names = arrayOf(
        "Bed",
        "Chair",
        "Dining Table",
        "Cushion Chair",
        "Sofa"
    )
    var description = arrayOf(
        "Soft Comfortable bed for you to sleep like baby. Made out of memory foam to give you a complete rest and wake up fresh every night",
        "Comfortable Chair for everyday work. Best suited for work/study desk. Enjoy your focused work on this comfortable chair. ",
        "6 seater dining table for family dining. Elegant design and minimalistic look that is must for every household. ",
        "Cushion chair for living room that would give it aesthetic modern royal look. Also, comfortable seating.",
        "Must have couch for every house that will give it a modern look. Comfortable seating for family and friends."
    )
    var price = arrayOf(
        "₹ 10,000",
        "₹ 2,000",
        "₹ 15,000",
        "₹ 8,000",
        "₹ 20,000"
    )
    private var images = intArrayOf(
        R.drawable.bed,
        R.drawable.chair,
        R.drawable.diningtable,
        R.drawable.royalchair,
        R.drawable.sofa,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cart
        btnCart = findViewById(R.id.btnCart)
        btnCart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        // For Grid View
        for (i in names.indices){
            modelList.add(Model(names[i],images[i],description[i],price[i]))
        }

        val customAdaptor = CustomAdaptor(modelList,this)
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = customAdaptor

        gridView.setOnItemClickListener{
            adapterView, view, i, l ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("data",modelList[i])
            startActivity(intent)
        }
    }

//
}
