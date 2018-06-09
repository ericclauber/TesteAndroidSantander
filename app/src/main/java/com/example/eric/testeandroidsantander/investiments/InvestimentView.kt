package com.example.eric.testeandroidsantander.investiments

import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.investiments.Screen

/**
 * Created by eric on 27/05/18.
 */
interface InvestimentView : BaseView {

    fun getInvestimentoSuccess(screen: Screen?)
    fun getInvestimentoError(error : String?)
}