package com.wix.jira

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.wix.jira.model.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val items = mutableListOf<Task>()

    // create item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskViewHolder(parent.createViewFromXml(R.layout.item_task))

    // fill data into item views
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = items[position]

        holder.cbTask.text = currentTask.title
        holder.cbTask.isChecked = currentTask.finished
    }

    fun updateItems(items: List<Task>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cbTask: CheckBox = itemView.findViewById(R.id.cbTask)
    }

    private fun ViewGroup.createViewFromXml(@LayoutRes layoutResId: Int): View =
        LayoutInflater.from(this.context).inflate(layoutResId, this, false)

}
