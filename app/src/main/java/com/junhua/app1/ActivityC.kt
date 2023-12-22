package com.junhua.app1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ActivityC : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        findViewById<Button>(R.id.back_btn).setOnClickListener { finish() }
        findViewById<Button>(R.id.next_btn).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
        findViewById<TextView>(R.id.tv).text = "App1ActivityC"
        findViewById<TextView>(R.id.task_tv).text = "App1ActivityC taskId: $taskId"
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("zjh", "ActivityC#onNewIntent")
    }

}