package example.clpal.looper

import android.os.Handler
import android.os.Message
import android.util.Log

class MyHandler : Handler() {
    private var TAG = "MyHandler"
    override fun handleMessage(msg: Message) {
        when (msg.what) {
            1 ->
                Log.d(TAG, "Task A Executed")
            2 -> Log.d(TAG, "Task B Executed")

        }
    }
}