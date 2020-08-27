package com.sunofbeaches.recyclervie

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageLoadUtils {
    companion object {
        @BindingAdapter("imagePath")
        @JvmStatic
        fun loadImage(image: ImageView, imageUrl: String?) {
            if (!TextUtils.isEmpty(imageUrl)) {
                Glide.with(image.context).load(imageUrl).into(image)
            }
        }
    }
}