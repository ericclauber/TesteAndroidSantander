package com.example.eric.testeandroidsantander.investimentos

import com.example.eric.testeandroidsantander.webservices.investimentos.Screen

/**
 * Created by eric on 27/05/18.
 */
interface OnInvestimentoListener {

    fun getScreenSuccess(screen: Screen?)
    fun getScreenError(error: String?)
}