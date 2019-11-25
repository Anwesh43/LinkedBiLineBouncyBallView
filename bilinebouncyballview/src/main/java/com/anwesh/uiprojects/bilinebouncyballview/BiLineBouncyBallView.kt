package com.anwesh.uiprojects.bilinebouncyballview

/**
 * Created by anweshmishra on 25/11/19.
 */

import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.view.MotionEvent

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#BDBDBD")
val rFactor : Float = 3.2f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * (Math.PI)).toFloat()

fun Canvas.drawBiLineBouncyBall(i : Int, size : Float, scale : Float, paint : Paint) {
    val sf : Float = scale.divideScale(0, 2).sinify()
    val sc : Float = scale.divideScale(1, 2)
    val r : Float = size / rFactor
    save()
    translate(size * (1f - 2 * i), 1f)
    drawLine(0f, 0f, 0f, -(size) * sf, paint)
    drawCircle(0f, 0f, r * sc, paint)
    restore()
}

fun Canvas.drawBLBBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), h / 2)
    for (j in 0..(lines - 1)) {
        drawBiLineBouncyBall(j, size, scale, paint)
    }
    restore()
}
