package com.example.eric.testeandroidsantander.investiments

import android.content.Context
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.investiments.Screen
import kotlin.properties.Delegates

/**
 * Created by eric on 27/05/18.
 */
class InvestimentoPresenterImpl : InvestimentoPresenter, OnInvestimentListener {

    var context: Context by Delegates.notNull()
    var view: InvestimentView by Delegates.notNull()
    var investimentoInteractorImpl: InvestimentoInteractorImpl by Delegates.notNull()

    constructor(context: Context, view: InvestimentView) {

        this.context = context
        this.view = view

        // TODO
        //if (!Utilities.isOnline(context)) {
        //  view.onConnectionFailed()
        //return
        //}

        view.showProgress(BaseView.ProgressType.PROGRESS_DIALOG)

        investimentoInteractorImpl = InvestimentoInteractorImpl()
    }

    override fun getScreen(context: Context) {

        investimentoInteractorImpl.geScreen(context, this)
    }

    override fun getScreenSuccess(screen: Screen?) {

        (context as BaseActivity).runOnUiThread {

            view.getInvestimentoSuccess(screen)
            view.hideProgress()
        }
    }

    override fun getScreenError(error: String?) {

        (context as BaseActivity).runOnUiThread {

            view.getInvestimentoError(error)
            view.hideProgress()
        }
    }
}

interface InvestimentoPresenter {

    fun getScreen(context: Context)
}