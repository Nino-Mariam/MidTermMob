package com.gabo.midtermexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabo.midtermexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPerson.setImageResource(R.drawable.ic_profile_empty)
        binding.ivPerson.setOnClickListener {
            switchActivity()
        }
        binding.ivEnter.setImageResource(R.drawable.ic_right)
        binding.ivEnter.setOnClickListener {
            sayHello()
        }
    }
    private fun sayHello(){
        val name = binding.edName.text.toString()
        val intent = Intent(this@MainActivity,SecondActivity::class.java)
        intent.putExtra("extra_name", name)
        startActivity(intent)
    }
    private fun switchActivity(){
        val intent = Intent(this@MainActivity,SecondActivity::class.java)
        startActivity(intent)
    }

}