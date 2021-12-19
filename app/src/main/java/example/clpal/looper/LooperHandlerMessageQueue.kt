package example.clpal.looper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.SystemClock
import android.util.Log
import example.clpal.handler.databinding.ActivityLooperHandlerMessageQueueBinding

class LooperHandlerMessageQueue : AppCompatActivity() {
    // https://www.youtube.com/playlist?list=PLkvHpL6WyuxvXF0zKSOScoqqWRBtl2ccG


    private lateinit var binding: ActivityLooperHandlerMessageQueueBinding
    val looperThread=MyLooperThread()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLooperHandlerMessageQueueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startThread.setOnClickListener({
            looperThread.start()
        })
        binding.stopThread.setOnClickListener({
            looperThread.looper.quit()

        })
        binding.TaskA.setOnClickListener({
            // with handler we can use
           /*val  tHandler=Handler(looperThread.looper)
            tHandler.post(object :Runnable{*/
           val msg= Message.obtain()
            msg.what=1
            looperThread.handler.sendMessage(msg)
        /*    looperThread.handler.post(object :Runnable{
                override fun run() {
                    for ( i in 1..5){
                        SystemClock.sleep(1000)
                        Log.d(TAG,"Task A run :"+i)
                    }
                }

            })*/

        })
        binding.TaskB.setOnClickListener({
            val msg= Message.obtain()
            msg.what=2
            looperThread.handler.sendMessage(msg)
        })
    }
}