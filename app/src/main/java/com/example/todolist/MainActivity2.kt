package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val title = findViewById<EditText>(R.id.title)
        val description = findViewById<EditText>(R.id.description)
        val btnadd = findViewById<Button>(R.id.add)
        btnadd.setOnClickListener{
            val texttitle = title.text.toString()
            val textdescription = description.text.toString()
            val intent = Intent()
            if(texttitle.isNotEmpty() && textdescription.isNotEmpty()){
                intent.putExtra("Extra_title",texttitle)
                intent.putExtra("Extra_description",textdescription)
                setResult(RESULT_OK,intent)
            }
            else{
                setResult(RESULT_CANCELED)
            }
            finish()
        }
    }
}