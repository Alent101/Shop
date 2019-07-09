package com.alent.shop

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nickname.*

class NicknameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname)

        btn_done.setOnClickListener {
            getSharedPreferences("shop", Context.MODE_PRIVATE)
                .edit()
                .putString("NICKNAME", ed_nick.text.toString())
                .apply()
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}