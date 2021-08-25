package com.example.testcrypto.util.extension

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.testcrypto.R


@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImage(imageUrl: String) {
//    Glide.with(context).load(imageUrl).into(this)
    this.load(imageUrl)
}

@BindingAdapter("setArrowBackground")
fun ImageView.setBackground(number: Double) {
    this.setBackgroundResource(if (number > 0) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down)
}



