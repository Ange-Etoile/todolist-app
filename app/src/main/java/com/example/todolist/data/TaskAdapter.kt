package com.example.todolist.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.todolist.R

class TaskAdapter(var othercontext: Context, var ressource :Int, var listTask : MutableList<Task> )
    :ArrayAdapter<Task>(othercontext,ressource,listTask){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = LayoutInflater.from(othercontext).inflate(ressource,parent,false)
        val task = listTask[position]
        val titre = itemView.findViewById<TextView>(R.id.title)
        titre.setText(task.title)
        return itemView

    }

}