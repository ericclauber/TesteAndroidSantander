package com.example.eric.testeandroidsantander.utils

import android.content.Context
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset

/**
 * Created by eric on 19/05/18.
 */
object Utils {

    fun parseJsonFromStringToList(jsonString: String, param: String, clazz: Class<*>): MutableList<Any> {

        val list: MutableList<Any> = ArrayList()

        val string = String(jsonString.toByteArray(Charsets.ISO_8859_1))

        try {
            val jsonObject = JSONObject(string)
            val objectArray = jsonObject.getJSONArray(param)
            val gson = Gson()

            for (i in 0..objectArray.length() - 1) {

                val any = gson.fromJson(objectArray.getString(i), clazz)
                list.add(any)
            }
        } catch (e: JSONException) {

            e.printStackTrace()
        }
        return list
    }

    fun parseJsonFromStringToObject(jsonString: String, param: String, clazz: Class<*>): Any {

        var any: Any? = null

        val string = String(jsonString.toByteArray(Charsets.ISO_8859_1))

        try {
            val jsonObject = JSONObject(string)
            val gson = Gson()

            any = gson.fromJson(jsonObject.getString(param), clazz)
        } catch (e: JSONException) {

            e.printStackTrace()
        }
        return any!!
    }

    fun dpToPixel(context: Context, dp: Int): Int {

        var density = context?.resources?.displayMetrics?.density
        return dp * density!!.toInt()
    }
}