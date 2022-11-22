package com.ssharanyab.furnituar.models

import android.media.Image

class Model : java.io.Serializable{
    var name: String?= null
    var desc: String?= null
    var price: String?= null
    var image: Int?=null

    constructor(name: String, image: Int, desc: String, price:String){
        this.name = name
        this.desc = desc
        this.image = image
        this.price = price
    }
}