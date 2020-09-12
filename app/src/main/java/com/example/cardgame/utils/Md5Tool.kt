package com.example.cardgame.utils

import android.util.Log
import java.security.MessageDigest
import kotlin.experimental.and

/**
 * MD5 加密的工具类
 *
 * @author 小雷
 * @date 2018/7/14
 */
object Md5Tool {
    /**
     * 将 password 与默认的当前的时间戳及字符串 "topsky" 进行拼接，进行 MD5 加密
     *
     * @param password 密码
     * @return 密文
     */
    fun encryptWithTimeStamp(password: String): String {
        //复合字符串，密码+时间戳（精确到十位）+混淆字符串
        val recombination =
            password + '_' + (System.currentTimeMillis() / 1000L / 100L + 1) + "_topsky"
        Log.d("Command", "password: $recombination")
        return encrypt(recombination).toUpperCase()
    }

    /**
     * 执行加密操作，输出密文
     *
     * @param content 要加密的内容
     * @return 密文
     */
    fun encrypt(content: String): String {
        val builder = StringBuilder()
        try {
            val md5 = MessageDigest.getInstance("MD5")
            md5.update(content.toByteArray())
            //加密
            val m = md5.digest()
            for (b in m) {
                if (b and 0xff.toByte() < 0x10) {
                    //一个byte为16字节，用两个char表示
                    //0x5 & 0xff = 5,0x05 & 0xff = 05 （用字符串表示便会有区别）
                    builder.append('0')
                }
                builder.append(Integer.toHexString((b and 0xff.toByte()).toInt()))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return builder.toString()
    }

    /**
     * 将 password 与指定的时间戳及字符串 "topsky" 进行拼接，进行 MD5 加密
     *
     * @param password  密码
     * @param timestamp 指定的时间戳
     * @return 密文
     */
    fun encryptWithTimeStamp(password: String, timestamp: String): String {
        //复合字符串，密码+时间戳（精确到十位）+混淆字符串
        val recombination = password + '_' + timestamp + "_topsky"
        return encrypt(recombination)
    }
}