package com.example.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.example.myfood.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        steupViews()
    }

    private fun steupViews(){
        val tableLayout = binding.addTab
        val viewPage = binding.addViewpager

        TabLayoutMediator(tableLayout, viewPage) {
            tab, position -> tab.text = "Novo texto"
        }.attach()
    }
}