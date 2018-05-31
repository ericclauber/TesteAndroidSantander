package com.example.eric.testeandroidsantander.investimentos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eric.testeandroidsantander.MainActivity
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.investimentos.Screen
import kotlin.properties.Delegates

/**
 * Created by eric on 27/05/18.
 */
class InvestimentoFragment : Fragment(), InvestimentoView {

    var investimentoPresenterImpl: InvestimentoPresenterImpl? = null
    var mActivity: MainActivity? = null


    companion object {

        fun getInstance(): InvestimentoFragment {

            val fragment = InvestimentoFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rooView = inflater.inflate(R.layout.fragmento_investimento, container, false)
        return rooView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initData()
    }

    fun initUI() {

        mActivity = (activity as MainActivity)
    }

    fun initData() {

        investimentoPresenterImpl = InvestimentoPresenterImpl(context!!, this)
        investimentoPresenterImpl?.getScreen(context!!)
    }


    override fun showProgress(type: BaseView.ProgressType) {

        mActivity?.onLoadingStart()
    }

    override fun hideProgress() {

        mActivity?.onLoadingFinish()
    }

    override fun onConnectionFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInvestimentoSuccess(screen: Screen?) {
       Log.d("TAG", "> > > > > > ${screen?.fundName}")
    }

    override fun getInvestimentoError(error: String?) {

        mActivity?.showToast("${ getString(R.string.url_error)}\n$error")
    }
}