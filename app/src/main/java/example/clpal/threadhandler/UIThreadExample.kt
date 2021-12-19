package example.clpal.threadhandler

import example.clpal.looper.LooperHandlerMessageQueue
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import example.clpal.handler.databinding.ActivityUithreadExampleBinding

class UIThreadExample : AppCompatActivity() {

    // Refernce videos  https://www.youtube.com/watch?v=Dmnx0iVRUss&t=659s
    private val TAG: String = "My Thread"
    private lateinit var binding: ActivityUithreadExampleBinding
    private var mstop: Boolean = false
    private var counter = 0
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUithreadExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val handler=  Handler()
        val handler = Handler(Looper.getMainLooper())
        // val handler=  Handler(applicationContext.getMainLooper())
        // val handler=  Handler(applicationContext.mainLooper)
        // handler = Handler(applicationContext.mainLooper)
        Log.e(TAG, "Thread is in Main ${Thread.currentThread().id}")
        binding.startloop.setOnClickListener {
            mstop = true
            Thread(object : Runnable {
                @Override
                override fun run() {

                    while (mstop) {
                        counter++
                        Log.e(
                            TAG,
                            "Thread is in While loop ${Thread.currentThread().id}${"\nCounter value :"} ${counter}"
                        )

                        //  first ways to update data in main with help of handler
                        /*handler.post {
                            binding.countText.text = "Counter Value" + counter.toString()
                        }*/
                        //  Second  ways to update data in main with help of handler
                        handler.post(object : Runnable {
                            override fun run() {
                                binding.countText.text = "Counter Value" + counter.toString()
                            }
                        })
                        // Third ways to update data in main with help of handler
                        /* binding.countText.post {

                             binding.countText.text = "Counter Value"+counter.toString()
                         }*/
                    }
                }
            }).start()
        }
        binding.stoploop.setOnClickListener {
            mstop = false
        }
        binding.next.setOnClickListener {
            Intent(this, LooperHandlerMessageQueue::class.java).apply {
                startActivity(this)
            }

        }
    }
}