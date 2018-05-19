package com.example.eric.testeandroidsantander.utils

import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by eric on 19/05/18.
 */
object Utils {

    fun parseJsonFromString(jsonString: String, param: String, clazz: Class<*>): MutableList<Any> {

        val list: MutableList<Any> = ArrayList()

        try {
            val jsonObject = JSONObject(jsonString)
            val objectArray = jsonObject.getJSONArray(param)
            val gson = Gson()

            for (i in 0..objectArray.length()) {

                val any = gson.fromJson(objectArray.getString(i), clazz)
                list.add(any)
            }
        } catch (e: JSONException) {

            e.printStackTrace()
        }
        return list
    }
}