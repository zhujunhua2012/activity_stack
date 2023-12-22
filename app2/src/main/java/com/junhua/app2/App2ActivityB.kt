package com.junhua.app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class App2ActivityB : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        findViewById<TextView>(R.id.tv).text = "App2ActivityB"
        findViewById<TextView>(R.id.task_tv).text = "App2ActivityB taskId: $taskId"
        findViewById<Button>(R.id.next_btn).setOnClickListener {
            startActivity(Intent(this, App2ActivityC::class.java).apply {
//                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
    }
}