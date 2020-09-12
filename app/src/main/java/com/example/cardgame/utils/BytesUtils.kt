package com.example.cardgame.utils

fun ByteArray.toInt(): Int {
    if (size != 4) {
        throw IllegalArgumentException("Byte Array should have 4 elements, now $size")
    }

    val bytes = this
    var result: Int = 0

    for (i in 0 until 4) {
        result = (result shl 8) or bytes[i].toInt()
    }

    return result
}