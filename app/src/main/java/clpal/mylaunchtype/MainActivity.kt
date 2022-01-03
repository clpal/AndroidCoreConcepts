package clpal.mylaunchtype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
// https://www.youtube.com/watch?v=xFkUm5mgb-U
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext,"onCreate called",Toast.LENGTH_LONG).show()
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(applicationContext,"onNewIntent called", Toast.LENGTH_LONG).show()
    }
    fun launchHome(view : View){
        startActivity(Intent(this,MainActivity::class.java))
    }
    fun launchfirstandsecond(view : View){
        startActivity(Intent(this,MainActivity3::class.java))
        startActivity(Intent(this,MainActivity4::class.java))
    }
}