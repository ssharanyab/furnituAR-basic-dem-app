package com.ssharanyab.furnituar.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ssharanyab.furnituar.models.Model
import com.ssharanyab.furnituar.R

class CustomAdaptor(
    var itemModel : ArrayList<Model>,
    var context: Context
): BaseAdapter(){
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
    override fun getCount(): Int {
        return itemModel.size
    }

    override fun getItem(p0: Int): Any {
        return itemModel[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        if (view==null){
            view= layoutInflater.inflate(R.layout.row_item,viewGroup,false)
        }
        var tvImageName = view?.findViewById<TextView>(R.id.imageName)
        var imageView = view?.findViewById<ImageView>(R.id.imageView)

        tvImageName?.text = itemModel[position].name
        imageView?.setImageResource(itemModel[position].image!!)

        return view!!
    }

}