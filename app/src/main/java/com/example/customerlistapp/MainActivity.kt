package com.example.customerlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Main Activity for a Single Activity Multi-Fragment architecture.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}