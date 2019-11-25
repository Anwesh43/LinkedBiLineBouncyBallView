package com.anwesh.uiprojects.linkedbilinebouncyballview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bilinebouncyballview.BiLineBouncyBallView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BiLineBouncyBallView.create(this)
    }
}
