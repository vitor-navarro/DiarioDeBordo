package com.example.diariodebordo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diariodebordo.R

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val startNewRouteButton: Button = findViewById(R.id.btnStartNewRoute)
        startNewRouteButton.setOnClickListener{
            val intent = Intent(this, RouteActivity::class.java)
            startActivity(intent)
        }

        val routesResumButton : Button = findViewById(R.id.btnRoutesResum)
        routesResumButton.setOnClickListener(){
            val intent = Intent(this, RoutesResumActivity::class.java)
            startActivity(intent)
        }
    }
}