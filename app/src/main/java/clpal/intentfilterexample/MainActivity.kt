package clpal.intentfilterexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // send button on click listener
        sendButton.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND) // intent
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "chhotelalpal59@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a dummy message")
            intent.putExtra(Intent.EXTRA_TEXT, "Dummy test message")
            startActivity(intent)
        }

        // View on click listener
        buttonView.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            startActivity(intent)
        }
    }
}