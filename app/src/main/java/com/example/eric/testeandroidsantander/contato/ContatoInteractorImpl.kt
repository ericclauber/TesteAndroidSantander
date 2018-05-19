package com.example.eric.testeandroidsantander.contato

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.eric.testeandroidsantander.webservices.Constants

/**
 * Created by eric on 19/05/18.
 */
class ContatoInteractorImpl : ContatoInteracor {

    override fun getCells(onContactListener: OnContactListener) {

        val stringRequest = StringRequest(Constants.URL_CELLS, Response.Listener<String> {

            onContactListener.getCellsSuccess()
        },
                Response.ErrorListener { })
    }
}

interface ContatoInteracor {

    fun getCells(onContactListener: OnContactListener)
}