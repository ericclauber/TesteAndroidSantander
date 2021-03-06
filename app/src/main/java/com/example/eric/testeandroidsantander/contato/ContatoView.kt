package com.example.eric.testeandroidsantander.contato

import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.contato.Cells

/**
 * Created by eric on 19/05/18.
 */
interface ContatoView : BaseView {

    fun getCellsSuccess(cells: MutableList<Cells>)
    fun getCellsError(error : String?)
}