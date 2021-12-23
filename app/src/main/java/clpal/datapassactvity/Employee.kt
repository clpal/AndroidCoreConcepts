package clpal.datapassactvity

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Employee(val userName:String,val mobile:String,val cityName:String):Serializable
data class Student(val userName:String?, val mobile: String?, val cityName:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(mobile)
        parcel.writeString(cityName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}
