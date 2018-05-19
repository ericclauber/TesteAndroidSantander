package com.example.eric.testeandroidsantander.contato

import com.example.eric.testeandroidsantander.webservices.contato.Cells

/**
 * Created by eric on 19/05/18.
 */
interface OnContactListener {

    fun getCellsSuccess(cells: MutableList<Cells>)
    fun getCellsError(error : String?)
}