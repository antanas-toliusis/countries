package com.antanas.demo.countries.main

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.antanas.demo.countries.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
