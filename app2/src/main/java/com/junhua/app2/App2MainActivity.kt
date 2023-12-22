package com.junhua.app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class App2MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.back_btn).setOnClickListener { finish() }
        findViewById<Button>(R.id.next_btn).setOnClickListener {
//            startActivity(Intent(this, ActivityA::class.java).apply {
////                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            })
            startActivity(Intent().apply {
                setClass(this@App2MainActivity, App2ActivityB::class.java)
//                setClassName(this@MainActivity, "com.junhua.app2.ActivityB")
//                component = ComponentName("com.junhua.app2", "com.junhua.app2.ActivityB")
//                setClassName("com.junhua.app2", "com.junhua.app2.App2ActivityB")
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
//        findViewById<Button>(R.id.go_btn).setOnClickListener {
//            startActivity(Intent(this, CanvasActivity::class.java).apply {
////                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            })
//        }
        findViewById<TextView>(R.id.task_tv).text = "App2MainActivity taskId: $taskId"
    }
}