package com.example.eric.testeandroidsantander.utils

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by eric on 19/05/18.
 */
object Utils {

    fun parseJsonFromStringToList(jsonString: String, param: String, clazz: Class<*>): MutableList<Any> {

        val list: MutableList<Any> = ArrayList()

        try {
            val jsonObject = JSONObject(jsonString)
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

        try {
            val jsonObject = JSONObject(jsonString)
            val gson = Gson()

            any = gson.fromJson(jsonObject.getString(param), clazz)
        } catch (e: JSONException) {

            e.printStackTrace()
        }
        return any!!
    }
}