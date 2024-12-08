package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.data.Task
import com.example.todolist.data.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val listTask : MutableList<Task> = mutableListOf()
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    override fun onStart() {
        super.onStart()


        val listview = findViewById<ListView>(R.id.listview)
        val btnadd = findViewById<FloatingActionButton>(R.id.btnadd)
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == RESULT_OK){
                val task = Task(result.data?.getStringExtra("Extra_title")?:"",result.data?.getStringExtra("Extra_description")?:"")
                listTask.add(task)
                val adapterResult = TaskAdapter(this,R.layout.activity_task,listTask)
                listview.adapter = adapterResult
            }
        }
        btnadd.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            resultLauncher.launch(intent)
        }




    }
}