package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.lotto.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val ball_list = listOf<TextView>(binding.num1, binding.num2,binding.num3, binding.num4,binding.num5, binding.num6)


        binding.click.setOnClickListener(){

            binding.lotteryWhirl.playAnimation()
            val countDownTimer = object : CountDownTimer(5000, 100){

                override fun onFinish() {
                }

                override fun onTick(millisUntilFinished: Long) {
                    val lottery_list = mutableListOf<Int>()
                    while (lottery_list.size <= 6){
                        val num = Random.nextInt(1, 45)
                        if(num in lottery_list) continue else lottery_list.add(num)
                    }

                    for(index in 0..5){
                        ball_list[index].setText(lottery_list[index].toString())
                    }
                }
            }
            countDownTimer.start()
        }
    }
}