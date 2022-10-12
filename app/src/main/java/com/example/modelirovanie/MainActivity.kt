package com.example.modelirovanie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEx=findViewById<Button>(R.id.exBtn1)
        btnEx.setOnClickListener{exit()}
        val btnLabOne=findViewById<Button>(R.id.button1)
        btnLabOne.setOnClickListener{ startLabActivity(1)}
        val btnLabTwo=findViewById<Button>(R.id.button2)
        btnLabTwo.setOnClickListener{startLabActivity(2)}
        val btnLabThree=findViewById<Button>(R.id.button3)
        btnLabThree.setOnClickListener{ startLabActivity(3)}
        val btnLabFour=findViewById<Button>(R.id.button4)
        btnLabFour.setOnClickListener{ startLabActivity(4)}

    }

    fun exit(){
        finish()
    }
    fun startLabActivity(labNumber:Int){
        val intent= Intent(this,LabActivity::class.java)
        intent.putExtra("Labaratoniynomer",labNumber)
        startActivity(intent)
    }
}