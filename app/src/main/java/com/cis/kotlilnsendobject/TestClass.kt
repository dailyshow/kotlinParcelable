package com.cis.kotlilnsendobject

import android.os.Parcel
import android.os.Parcelable

// parcel은 객체를 그대로 전달하는 개념이 아니다.
// a가 객체가 갖고 있는 값을 전달 해서 b에서 새로운 객체를 만들어 값을 복원하게 된다.
class TestClass : Parcelable {
    var data10 = 0
    var data20: String? = null

    companion object {
        @JvmField

        // intent로부터 객체를 복원할 때는 아래 두 개의 메소드 중 해당하는 메소드가 호출된다.
        val CREATOR : Parcelable.Creator<TestClass> = object : Parcelable.Creator<TestClass> {
            // 객체 하나만 넣어서 넘길 경우에 createFromParcel 메소드 호출
            override fun createFromParcel(source: Parcel?): TestClass { // 객체를 복원하는 parcel
                val test = TestClass()
                test.data10 = source?.readInt()!!
                test.data20 = source.readString()

                return test
            }

            // 객체 하나가 아니라 배열이 보내지면 newArray 메소드 호출됨
            override fun newArray(size: Int): Array<TestClass?> {
                return arrayOfNulls<TestClass>(size)
            }
        }
    }

    // intent에 객체를 담을 때는 writeToParcel 메소드가 호출됨
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(data10)
        dest?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }
}