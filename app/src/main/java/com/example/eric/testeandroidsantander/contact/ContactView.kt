package com.example.eric.testeandroidsantander.contact

import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.contact.Cells

/**
 * Created by eric on 19/05/18.
 */
interface ContactView : BaseView {

    fun getCellsSuccess(cells: MutableList<Cells>)
    fun getCellsError(error : String?)
}