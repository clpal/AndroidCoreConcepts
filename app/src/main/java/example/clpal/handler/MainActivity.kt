package example.clpal.handler

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import example.clpal.handler.R

class MainActivity : AppCompatActivity() {
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById(R.id.tv) as TextView
       val countDownTimer= object : CountDownTimer(10000,1000) {
            override fun onTick(p0: Long) {
                number ++
                tv.text=number.toString()
            }

            override fun onFinish() {
              tv.text="finished"
            }

        }//.start()
        countDownTimer.start()
        // Task scheduler using  Handler and Runnable
         val handler=Handler()
         val runnable= object :Runnable{
             @Override
              override fun run() {
                  number++
                  Toast.makeText(this@MainActivity,"number$number",Toast.LENGTH_LONG).show()
             handler.postDelayed(this,1000)
              }

          }
         handler.post(runnable)
    }
}