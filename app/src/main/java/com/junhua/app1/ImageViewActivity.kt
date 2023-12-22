package com.junhua.app1

import android.os.Bundle
import android.widget.ImageView

class ImageViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imageview)
//        findViewById<ImageView>(R.id.iv).setImageResource(R.drawable.shape_image_placeholder)
        findViewById<ImageView>(R.id.iv).setBackgroundResource(R.drawable.shape_image_placeholder)
    }
}