package com.example.eric.testeandroidsantander.investiments

import com.example.eric.testeandroidsantander.webservices.investiments.Screen

/**
 * Created by eric on 27/05/18.
 */
interface OnInvestimentListener {

    fun getScreenSuccess(screen: Screen?)
    fun getScreenError(error: String?)
}