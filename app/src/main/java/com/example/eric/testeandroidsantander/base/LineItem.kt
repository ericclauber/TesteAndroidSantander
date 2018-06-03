package com.example.eric.testeandroidsantander.base

/**
 * Created by eric on 03/06/18.
 */
class LineItem(obj: Any, isHeader: Boolean, sectionFirstPosition: Int, type: Int) {

    var sectionFirstPosition = 0
    var type = 0
    var isHeader = false
    var obj: Any? = null

    init {
        this.sectionFirstPosition = sectionFirstPosition
        this.type = type
        this.isHeader = isHeader
        this.obj = obj
    }

}