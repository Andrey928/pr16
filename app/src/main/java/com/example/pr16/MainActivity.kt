package com.example.pr16

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.IDNA.Info
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        updateMenuTheme(menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_item-> {
                toggleTheme()
                return true
            }
            R.id.about_menu_item -> {
                val intent = Intent(this@MainActivity, activity_info::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun toggleTheme() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }

    private fun updateMenuTheme(menu: Menu?) {
        if (menu != null) {
            val themeSwitch = menu.findItem(R.id.settings_menu_item)
            if (themeSwitch != null) {
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    themeSwitch.title = "Сменить на светлую"
                    themeSwitch.setIcon(R.drawable.icon)
                } else {
                    themeSwitch.title = "Сменить на тёмную"
                    themeSwitch.setIcon(R.drawable.icon)
                }
            }
        }
    }

    }

