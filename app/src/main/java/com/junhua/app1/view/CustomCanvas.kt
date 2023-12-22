package com.junhua.app1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.junhua.app1.R

class CustomCanvas : View {

    private val mPaint = Paint().apply {
        color = resources.getColor(R.color.gray)
        strokeWidth = resources.getDimension(R.dimen.dp_5)
    }

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val measuredWidth = measuredWidth * 1f
        val measuredHeight = measuredHeight * 1f
        // background
        canvas?.drawRect(0f, 0f, measuredWidth, measuredHeight, mPaint)

        canvas?.save()
        canvas?.rotate(-90f, measuredWidth / 2, measuredHeight / 2)
        // arrow
//        canvas?.scale(0.9f, 0.9f)
        mPaint.color = resources.getColor(R.color.green)
        canvas?.drawLine(measuredWidth / 2, 0f, measuredWidth, measuredHeight / 2, mPaint)
        canvas?.drawLine(0f, measuredHeight / 2, measuredWidth, measuredHeight / 2, mPaint)
        canvas?.drawLine(measuredWidth / 2, measuredHeight, measuredWidth, measuredHeight / 2, mPaint)
        mPaint.color = resources.getColor(R.color.red)
        canvas?.drawCircle(measuredWidth / 2, measuredHeight, 20f, mPaint)
        canvas?.restore()
        // circle
        mPaint.color = resources.getColor(R.color.green)
        canvas?.drawCircle(measuredWidth - 20, measuredHeight - 20, 20f, mPaint)
    }
}