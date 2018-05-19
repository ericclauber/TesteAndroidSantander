package com.example.eric.testeandroidsantander.contato

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.eric.testeandroidsantander.utils.Utils
import com.example.eric.testeandroidsantander.webservices.Constants
import com.example.eric.testeandroidsantander.webservices.contato.Cells

/**
 * Created by eric on 19/05/18.
 */
class ContatoInteractorImpl : ContatoInteracor {

    override fun getCells(context: Context, onContactListener: OnContactListener) {

        val stringRequest = StringRequest(Constants.URL_CELLS, Response.Listener<String> {

            val cellsList = Utils.parseJsonFromString(it, "cells") as MutableList<Cells>
            onContactListener.getCellsSuccess(cellsList)
        },
                Response.ErrorListener {

                    onContactListener.getCellsError(it.message)
                })

        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }
}

interface ContatoInteracor {

    fun getCells(context: Context, onContactListener: OnContactListener)
}