package com.cis.kotlilnsendobject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

// intent 를 통해 객체를 전달할 때는 parcelable 인터페이스를 구한 클래스의 객체만 전달이 가능하다.
// serializable 도 객체 직렬화를 할 수 있음. 하지만 parcelable을 사용하는것이 더 좋음
// 배터리 드레인 문제와 퍼포먼스 저하때문이다.
// serializable보다 훨씬 복잡하긴 하지만 사용할만한 가치가 있음.
class MainActivity : AppCompatActivity() {
    val SECOND_ACTIVITY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBtn.setOnClickListener { view ->
            val test1 = TestClass()
            test1.data10 = 100
            test1.data20 = "문자열~~"

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("test1", test1)
            startActivityForResult(intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            var t3 = data?.getParcelableExtra<TestClass>("test3")
            mainTv.text = "t3.data10 : ${t3?.data10}\n"
            mainTv.append("t3.data20 : ${t3?.data20}")
        }
    }
}
