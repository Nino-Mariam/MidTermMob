package com.gabo.midtermexam

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabo.midtermexam.databinding.ActivitySecondBinding

class SecondActivity() : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPerson.setImageResource(R.drawable.ic_profile_empty)
        binding.btnBack.setImageResource(R.drawable.ic_back)
        binding.btnBack.setOnClickListener {
            goBack()
        }

        saveData()
        loadData()
    }

    private fun goBack() {
        saveData()
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun saveData() {
        val name = intent.getStringExtra("extra_name")

        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if (name != null && name != "") {
            editor.apply {
                putString("name_key", name)
            }.apply()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val savedString = sharedPreferences.getString("name_key", "")

            binding.tvHello.text = "Hello, $savedString!"
        }

    }