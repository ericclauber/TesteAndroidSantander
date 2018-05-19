package com.example.eric.testeandroidsantander.utils

import com.example.eric.testeandroidsantander.webservices.contato.Cells
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by eric on 19/05/18.
 */
object Utils {

    fun parseJsonFromString(jsonString: String, param: String): MutableList<Any> {

        val list: MutableList<Any> = ArrayList()

        try {

            val jsonObject = JSONObject(jsonString)
            val objectArray = jsonObject.getJSONArray(param)
            val gson = Gson()

            for (i in 0..objectArray.length()) {

                val cell = gson.fromJson(i.toString(), Cells::class.java) as Cells
                list.add(cell)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}