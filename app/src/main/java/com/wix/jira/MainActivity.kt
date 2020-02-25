package com.wix.jira

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.wix.jira.model.Task
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_tasks_list.*

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf(
        Task(title = "create app"),
        Task(title = "buy bread", finished = true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vwEmptyList.visibility = View.GONE
        val adapter = TaskAdapter()
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = adapter
        adapter.updateItems(items)

        btAddTask.isEnabled = false
        etTask.addTextChangedListener { text ->
            btAddTask.isEnabled = text!!.toString().trim().length >= 3
        }

        btAddTask.setOnClickListener {
            val newTask = Task(title = etTask.text.toString().trim())

            items.add(0, newTask)
            etTask.setText("")

            adapter.updateItems(items)
        }
    }
}
