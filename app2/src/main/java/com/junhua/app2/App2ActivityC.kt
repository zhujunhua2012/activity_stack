package com.junhua.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class App2ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        findViewById<TextView>(R.id.tv).text = "App2ActivityC"
        findViewById<TextView>(R.id.task_tv).text = "App2ActivityC taskId: $taskId"
    }
}