package com.ssharanyab.furnituar.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ssharanyab.furnituar.Product
import com.ssharanyab.furnituar.R

class AdapterCart:RecyclerView.Adapter<AdapterCart.ViewHolder>() {

    private var products = emptyList<Product>()

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tvCartName: TextView = itemView.findViewById(R.id.tvCartName)
        val tvCartPrice: TextView = itemView.findViewById(R.id.tvCartPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item_cart,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = products[position]
        holder.tvCartName.text = currentProduct.name
        holder.tvCartPrice.text = currentProduct.price.toString()
    }

    override fun getItemCount(): Int {
        return products.size
    }
    fun setData(product: List<Product>){
        this.products = product
        notifyDataSetChanged()
    }

}
