package example.clpal.asynktaskweakreference

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import example.clpal.asynktaskweakreference.databinding.ActivityMainBinding
import java.lang.ref.WeakReference

// https://www.youtube.com/watch?v=wmYjSAGf-Z0&list=PLkvHpL6WyuxvXF0zKSOScoqqWRBtl2ccG&index=4
class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var binding: ActivityMainBinding
        val context: Context = MainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startExecution.setOnClickListener {
            val myAsyncTask = MyAsyncTask(this)
            myAsyncTask.execute(10)
        }
    }

    private class MyAsyncTask(activity: MainActivity) : AsyncTask<Int, Int, String>() {
        private var weakReference: WeakReference<MainActivity> =
            WeakReference<MainActivity>(activity)

        /*init {
            weakActivity =  WeakReference<MainActivity>(activity)
        }
*/
        override fun onPreExecute() {
            super.onPreExecute()
            val activity: MainActivity? = weakReference.get()
            if (activity == null || activity.isFinishing)
                return
            binding.progressBar.isVisible = true
        }

        override fun doInBackground(vararg p: Int?): String? {
            for (i in 0..p[0]!!) {
                publishProgress((i * 100) / p[0]!!)
                SystemClock.sleep(1000)
            }
            return "Task Finished .....!"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val activity: MainActivity? = weakReference.get()
            if (activity == null || activity.isFinishing)
                return
            binding.progressBar.setProgress(values[0]!!)
        }

        override fun onPostExecute(result: String?) {
            val activity: MainActivity? = weakReference.get()
            if (activity == null || activity.isFinishing)
                return
            Toast.makeText(activity, "" + result, Toast.LENGTH_LONG).show()
            /// Toast.makeText(context,""+result,Toast.LENGTH_LONG).show()
            binding.progressBar.setProgress(0)
            binding.progressBar.isInvisible = true
        }

        override fun onCancelled(result: String?) {
            super.onCancelled(result)
        }


    }
}