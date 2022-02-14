package com.example.foreground_prac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    var btn_start : ToggleButton? = null
    var btn_end : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btn_start)
        btn_end = findViewById(R.id.btn_stop)

        btn_start!!.setOnClickListener(View.OnClickListener {

            if(btn_start!!.isChecked == true){
                btn_start!!.setBackground(resources.getDrawable(R.drawable.pause_btn, null))
                val serviceIntent = Intent(this@MainActivity, MyService::class.java)
                startService(serviceIntent)
                Toast.makeText(this@MainActivity, "Service start", Toast.LENGTH_SHORT).show()
            }else{
                btn_start!!.setBackground(resources.getDrawable(R.drawable.start_btn,null))
            }
        })



        btn_end!!.setOnClickListener(View.OnClickListener {

            btn_start!!.setBackground(resources.getDrawable(R.drawable.start_btn,null))
            val serviceIntent = Intent(this@MainActivity, MyService::class.java)
            stopService(serviceIntent)
            Toast.makeText(this@MainActivity, "Service stop", Toast.LENGTH_SHORT).show()
        })
    }
}