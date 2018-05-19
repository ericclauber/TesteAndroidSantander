package com.example.eric.testeandroidsantander.contato

import android.content.Context
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.contato.Cells
import kotlin.properties.Delegates

/**
 * Created by eric on 19/05/18.
 */
class ContatoPresenterImpl : ContatoPresenter, OnContactListener {

    var context: Context by Delegates.notNull()
    var view: ContatoView by Delegates.notNull()
    var contatoInteractorImpl: ContatoInteractorImpl by Delegates.notNull()

    constructor(context: Context, view: ContatoView) {

        this.context = context
        this.view = view

        // TODO
        //if (!Utilities.isOnline(context)) {
        //  view.onConnectionFailed()
        //return
        //}

        view.showProgress(BaseView.ProgressType.PROGRESS_DIALOG)

        contatoInteractorImpl = ContatoInteractorImpl()
    }

    override fun getCells(context: Context) {

        contatoInteractorImpl.getCells(context, this)
    }

    override fun getCellsSuccess(cells: MutableList<Cells>) {
        context.run {

            view.hideProgress()
            view.getCellsSuccess(cells)
        }
    }

    override fun getCellsError(error: String?) {
        context.run {

            view.hideProgress()
            view.getCellsError(error)
        }
    }
}

interface ContatoPresenter {

    fun getCells(context: Context)
}