package com.junhua.app1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ActivityD : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        findViewById<Button>(R.id.back_btn).setOnClickListener { finish() }
        findViewById<Button>(R.id.next_btn).setOnClickListener {
//            startActivity(Intent(this, ActivityB::class.java))
        }
        findViewById<TextView>(R.id.tv).text = "App1ActivityD"
        findViewById<TextView>(R.id.task_tv).text = "App1ActivityD taskId: $taskId"
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("zjh", "ActivityD#onNewIntent")
    }

}