package com.example.eric.testeandroidsantander.contact

import android.content.Context
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.contact.Cells
import kotlin.properties.Delegates

/**
 * Created by eric on 19/05/18.
 */
class ContatoPresenterImpl : ContatoPresenter, OnContactListener {

    var context: Context by Delegates.notNull()
    var view: ContactView by Delegates.notNull()
    var contatoInteractorImpl: ContatoInteractorImpl by Delegates.notNull()

    constructor(context: Context, view: ContactView) {

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

        (context as BaseActivity).runOnUiThread {

            view.getCellsSuccess(cells)
            view.hideProgress()
        }
    }

    override fun getCellsError(error: String?) {

        (context as BaseActivity).runOnUiThread {

            view.getCellsError(error)
            view.hideProgress()
        }
    }
}

interface ContatoPresenter {

    fun getCells(context: Context)
}