package com.example.cardgame.utils

import com.google.gson.Gson

object GsonUtil {
    private val gson = Gson()
    fun toJson(src: Any?): String {
        return gson.toJson(src)
    }
}