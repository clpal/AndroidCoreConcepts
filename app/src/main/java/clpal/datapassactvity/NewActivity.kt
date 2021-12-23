package clpal.datapassactvity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import clpal.datapassactvity.databinding.ActivityNewBinding
class NewActivity : AppCompatActivity() {
    companion object {
        const val employeeInfo: String = "employeePassed"
    }
    private var binding: ActivityNewBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding?.root)
       //val employee:Employee= intent.getSerializableExtra(employeeInfo) as Employee
     //  val employee:Student= intent.getSerializableExtra(employeeInfo) as Student
       val employee:Student= intent.getParcelableExtra(employeeInfo)!!
       // binding?.showData?.text=employee.cityName.toString()
        binding?.showData?.text=employee.toString()
         Handler(Looper.getMainLooper()).postDelayed(Runnable {
             binding?.showData?.text="${"Name :"+employee.userName}\n ${"Mobile Number :"+employee.mobile}\n ${"City Name :"+employee.cityName}"
         },4000)
     }
}