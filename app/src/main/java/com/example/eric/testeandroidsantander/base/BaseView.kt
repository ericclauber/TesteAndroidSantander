package com.example.eric.testeandroidsantander.base

/**
 * Created by eric on 19/05/18.
 */
interface BaseView {

    enum class ProgressType {
        PROGRESS_DIALOG,
    }


    fun showProgress(type: ProgressType)
    fun hideProgress()
    fun onConnectionFailed()
}