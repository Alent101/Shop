package com.alent.shop

import android.app.Activity
import android.content.Context
import kotlinx.android.synthetic.main.activity_nickname.*

fun Activity.setNickname(nickname: String) {
    getSharedPreferences("shop", Context.MODE_PRIVATE)
        .edit()
        .putString("NICKNAME", nickname)
        .apply()
}

fun Activity.getNickname(): String {
    return getSharedPreferences("shop", Context.MODE_PRIVATE).getString("NICKNAME", "")
}