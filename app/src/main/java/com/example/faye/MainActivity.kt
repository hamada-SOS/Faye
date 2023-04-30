package com.example.faye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.faye.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resyclerview.adapter = CardAdapter(this)
        binding.resyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.showWindowBtn.setOnClickListener{
            val window = PopupWindow(this)
            window.isFocusable = true
            val view = layoutInflater.inflate(R.layout.popup_window, null)
            window.contentView = view
            val addbtn = view.findViewById<Button>(R.id.addItemBtn)
            addbtn.setOnClickListener {
                window.dismiss()
            }
            window.showAtLocation(view, Gravity.CENTER, 0, 0)

        }

    }
}







