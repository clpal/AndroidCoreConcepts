package example.clpal.looper

import android.os.Handler
import android.os.Looper
import android.util.Log

class MyLooperThread : Thread() {
    //https://www.youtube.com/channel/UCVdpWaq_J4vuUFhTc7U6zsA
    private var TAG = "MyLooperThread"
   lateinit var handler:Handler
    lateinit  var looper:Looper

    override fun run() {
        Looper.prepare()
        looper= Looper.myLooper()!!
        // handler=Handler()
         handler=MyHandler()
        Looper.loop()
   /*     for (i in 1..5) {
            Log.d(TAG, "Run${i}")
            SystemClock.sleep(100)
        }
        Log.d(TAG, "End of Run()")*/
        Log.d(TAG, "End of looper")
    }
}