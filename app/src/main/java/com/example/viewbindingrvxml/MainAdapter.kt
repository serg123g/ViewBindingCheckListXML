package com.example.viewbindingrvxml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingrvxml.databinding.RecyclerviewItemBinding
import kotlinx.coroutines.NonDisposableHandle

class MainAdapter(val taskList: List<Task>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(private val itemBinding: RecyclerviewItemBinding)
        :RecyclerView.ViewHolder(itemBinding.root)
    {
            fun bindItem(task: Task){
                itemBinding.titleTv.text = task.title
                itemBinding.timeTv.text = task.timeStamp
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(
            parent.context)))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}