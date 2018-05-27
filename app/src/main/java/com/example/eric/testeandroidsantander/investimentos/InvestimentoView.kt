package com.example.eric.testeandroidsantander.investimentos

import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.investimentos.Screen

/**
 * Created by eric on 27/05/18.
 */
interface InvestimentoView : BaseView {

    fun getInvestimentoSuccess(screen: Screen?)
    fun getInvestimentoError(error : String?)
}