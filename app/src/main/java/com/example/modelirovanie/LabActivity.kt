package com.example.modelirovanie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modelirovanie.Fragments.LabaratonayaThreeFragment
import com.example.modelirovanie.Fragments.LabaratornayOneFragment
import com.example.modelirovanie.Fragments.LabaratornayTwoFragment
import com.example.modelirovanie.Fragments.LabaratornayaForeFragment

class LabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab)
        val intent=intent
        when(intent.getIntExtra("Labaratoniynomer",0)){
            1->{
                val fragmentFirst=LabaratornayOneFragment()
                supportFragmentManager.beginTransaction().apply {
                replace(R.id.fLfragment, fragmentFirst)
                commit()
            }}
            2->{
                val fragmetSecond=LabaratornayTwoFragment()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fLfragment,fragmetSecond)
                    commit()
                }
            }
            3->{
                val fragmentThird=LabaratonayaThreeFragment()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fLfragment,fragmentThird)
                    commit()
                 }
            }
            4->{
                val fragmentThird=LabaratornayaForeFragment()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fLfragment,fragmentThird)
                    commit()
                }
            }

            else->finish()
        }
    }
}