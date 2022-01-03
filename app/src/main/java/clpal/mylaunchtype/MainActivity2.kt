package clpal.mylaunchtype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
// https://www.youtube.com/watch?v=xFkUm5mgb-U
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Toast.makeText(applicationContext,"onCreate called",Toast.LENGTH_LONG).show()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(applicationContext,"onNewIntent called",Toast.LENGTH_LONG).show()
    }
    fun launchAnotherActvity(view :View){
        startActivity(Intent(this,MainActivity::class.java))
    }
    fun launchthisActvityagain(view :View){
        startActivity(Intent(this,MainActivity2::class.java))
    }
}