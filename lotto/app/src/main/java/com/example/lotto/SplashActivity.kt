package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.lotto.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, 3000)

        binding.animationView.setOnClickListener(){
            handler.removeCallbacks(runnable)
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
            finish()
        }
    }
}