package com.example.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.base.Activities.AuxiliarActivity1
import com.example.base.Activities.AuxiliarActivity2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun navigateToAct2(view: View) {
        startActivity(
            Intent(this, AuxiliarActivity2::class.java)
        )
    }
    fun navigateToAct1(view: View) {
        startActivity(Intent(this, AuxiliarActivity1::class.java))
    }

}