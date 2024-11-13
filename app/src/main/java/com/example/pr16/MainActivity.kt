package com.example.pr16

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val switch = findViewById<Switch>(R.id.switch1)


            switch.isChecked =
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO

            switch.setOnCheckedChangeListener { _, isChecked ->
                setTheme(isChecked)
            }
        }

        private fun setTheme(isWhiteMode: Boolean) {
            if (isWhiteMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate. MODE_NIGHT_NO)
            }
        }
    }

