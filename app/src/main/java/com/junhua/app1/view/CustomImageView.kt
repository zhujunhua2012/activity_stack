package com.junhua.app1.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.junhua.app1.R

class CustomImageView : AppCompatImageView {

    private val paint: Paint = Paint()
    private val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_48_kot)
    private val drawable = BitmapDrawable(resources, bitmap)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d("zjh", "#onDraw, canvas ${canvas?.width} * ${canvas?.height}")
        val width = measuredWidth
        val height = measuredHeight
        val margin = resources.getDimension(R.dimen.margin_10)
        val radius = resources.getDimension(R.dimen.margin_10)
        paint.color = resources.getColor(R.color.purple_200)
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = resources.getDimension(R.dimen.dp_18)
        canvas?.drawRoundRect(margin, margin, width - margin, height - margin, radius, radius, paint)
        paint.color = resources.getColor(R.color.red)
        paint.strokeWidth = resources.getDimension(R.dimen.dp_1)
        canvas?.drawRoundRect(margin, margin, width - margin, height - margin, radius, radius, paint)
        paint.color = resources.getColor(R.color.red)
        // 刻度线
        canvas?.drawLine(0f, 0f, 0.2f, 10f, paint)
        canvas?.drawLine(100f, 0f, 100.2f, 15f, paint)
        canvas?.drawLine(200f, 0f, 200.2f, 20f, paint)
        canvas?.drawLine(300f, 0f, 300.2f, 25f, paint)
        canvas?.drawLine(400f, 0f, 400.2f, 30f, paint)
        canvas?.drawLine(500f, 0f, 500.2f, 35f, paint)
        Log.d("zjh", "#onDraw, bitmap ${bitmap.width} * ${bitmap.height}")
//        canvas?.drawBitmap(bitmap, margin, margin, paint)
//        val srcRect = Rect(
//            margin.toInt(),
//            margin.toInt(),
//            (margin + bitmap.width).toInt(),
//            (margin + bitmap.height).toInt()
//        )
        // 目标矩形
        paint.style = Paint.Style.FILL
        paint.color = resources.getColor(R.color.teal_700)
        canvas?.drawRect(100f, 100f, 300f, 300f, paint)
        val srcRect = Rect(
            bitmap.width/3,
            bitmap.height/3,
            bitmap.width + 10,
            bitmap.height + 10
        )
        val dstRect = Rect(100, 100, 300, 300)
        canvas?.drawBitmap(bitmap, srcRect, dstRect, paint)
        Log.d("zjh", "#onDraw, drawable ${drawable.intrinsicWidth} * ${drawable.intrinsicHeight}")
        drawable.setBounds(300, 300, 500, 500)
        canvas?.let {
            drawable.draw(it)
        }
        // bitmap的三分线
        paint.color = resources.getColor(R.color.red)
        canvas?.drawLine(300f, 366.67f, 500f, 366.70f, paint)
        canvas?.drawLine(300f, 433.33f, 500f, 433.33f, paint)
        canvas?.drawLine(366.67f, 300f, 366.67f, 500f, paint)
        canvas?.drawLine(433.33f, 300f, 433.33f, 500f, paint)
    }
}