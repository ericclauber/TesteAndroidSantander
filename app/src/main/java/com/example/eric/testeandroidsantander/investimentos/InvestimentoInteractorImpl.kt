package com.example.eric.testeandroidsantander.investimentos

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.eric.testeandroidsantander.utils.Utils
import com.example.eric.testeandroidsantander.webservices.Constants
import com.example.eric.testeandroidsantander.webservices.investimentos.Screen

/**
 * Created by eric on 27/05/18.
 */
class InvestimentoInteractorImpl : InvestimentoInteractor {
    override fun geScreen(context: Context, onInvestimentoListener: OnInvestimentoListener) {

        val stringRequest = StringRequest(Constants.URL_FUND, Response.Listener<String> {

            val screen = Utils.parseJsonFromStringToObject(it, "screen", Screen::class.java)
                    as Screen

            onInvestimentoListener.getScreenSuccess(screen)

        }, Response.ErrorListener {

            onInvestimentoListener.getScreenError(it.message)
        })

        val requestQueue = Volley.newRequestQueue(context)
        requestQueue.add(stringRequest)
    }
}

interface InvestimentoInteractor {

    fun geScreen(context: Context, onInvestimentoListener: OnInvestimentoListener)
}