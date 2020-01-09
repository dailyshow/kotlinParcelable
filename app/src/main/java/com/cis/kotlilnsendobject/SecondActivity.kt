package com.cis.kotlilnsendobject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val test2 = intent.getParcelableExtra<TestClass>("test1")

        secondTv.text = "test2.data10 : ${test2.data10}\n"
        secondTv.append("test2.data20 : ${test2.data20}")

        secondBtn.setOnClickListener { view ->
            val test3 = TestClass()
            test3.data10 = 200
            test3.data20 = "문자열3333"

            var intent3 = Intent()
            intent3.putExtra("test3", test3)
            setResult(Activity.RESULT_OK, intent3)
            finish()
        }
    }
}
