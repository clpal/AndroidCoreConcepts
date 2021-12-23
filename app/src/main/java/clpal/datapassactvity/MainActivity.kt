package clpal.datapassactvity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import clpal.datapassactvity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.submitBtn?.setOnClickListener {

            val userName = binding?.userName?.text.toString()
            val mobile = binding?.mobile?.text.toString()
            val cityName = binding?.cityName?.text.toString()
            val employee = Employee(userName, mobile, cityName)
            val student = Student(userName, mobile, cityName)
            /*if(TextUtils.isEmpty(userName)){
                binding?.userName?.error="Please enter user name"
            }
            if (TextUtils.isEmpty(mobile) || mobile.length>10)*/
            val intent = Intent(this, NewActivity::class.java)
            intent.apply {
                putExtra(NewActivity.employeeInfo, student) // seriaziable && parceble
                startActivity(this) }
        }
    }
}