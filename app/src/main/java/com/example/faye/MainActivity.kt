package com.example.faye

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Layout
import android.view.Gravity
import android.widget.Button
import android.widget.PopupWindow
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.faye.databinding.ActivityMainBinding
import com.example.faye.databinding.PopupWindowBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.popup_window)



        binding.resyclerview.adapter = CardAdapter(this)
        binding.resyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        binding.showWindowBtn.setOnClickListener {

            val window = PopupWindow(this)
            window.isFocusable = true
            val view = layoutInflater.inflate(R.layout.popup_window , null)
            window.contentView = view
            val addbtn = view.findViewById<Button>(R.id.addItemBtn)

            addbtn.setOnClickListener {
                window.dismiss()
            }
            window.showAtLocation(view, Gravity.CENTER, 0, 0)

        }

        val getContent =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                // Handle the returned Uri
            }

        val addImageBtn = findViewById<Button>(R.id.addImageBtn)
        addImageBtn.setOnClickListener {
            getContent.launch("image/*")
        }

    }

}











