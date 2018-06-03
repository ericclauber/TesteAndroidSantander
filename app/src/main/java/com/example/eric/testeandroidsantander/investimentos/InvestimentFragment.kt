package com.example.eric.testeandroidsantander.investimentos

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eric.testeandroidsantander.MainActivity
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.base.LineItem
import com.example.eric.testeandroidsantander.investimentos.adapter.InvestmentAdapter
import com.example.eric.testeandroidsantander.webservices.investimentos.MoreInfo
import com.example.eric.testeandroidsantander.webservices.investimentos.Screen
import kotlinx.android.synthetic.main.fragment_investimento.*

/**
 * Created by eric on 27/05/18.
 */
class InvestimentFragment : Fragment(), InvestimentoView, InvestmentAdapter.OnClickListener {

    var investimentoPresenterImpl: InvestimentoPresenterImpl? = null
    var mActivity: MainActivity? = null
    var mInvestmentAdapter: InvestmentAdapter? = null
    var mLineItemList: MutableList<LineItem>? = ArrayList()


    companion object {

        val TYPE_HEADER = 0
        val TYPE_MORE_INFO = 1
        val TYPE_INFO = 2
        val TYPE_DOWN_INFO = 3

        fun getInstance(): InvestimentFragment {

            val fragment = InvestimentFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rooView = inflater.inflate(R.layout.fragment_investimento, container, false)
        return rooView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initData()
    }

    fun initUI() {

        mActivity = (activity as MainActivity)

//        viewRisk4.layoutParams.height = dpToPixel(12)
    }

    fun initData() {

        investimentoPresenterImpl = InvestimentoPresenterImpl(context!!, this)
        investimentoPresenterImpl?.getScreen(context!!)

       // setupRecyclerView()
    }

    fun setupRecyclerView() {

        mInvestmentAdapter = InvestmentAdapter(context!!, this, mLineItemList!!)

        var llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewInvestment.setHasFixedSize(true)
        recyclerViewInvestment.layoutManager = llm

        recyclerViewInvestment.adapter = mInvestmentAdapter
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

        var screenHeader = screen
        screenHeader?.downInfo?.clear()
        screenHeader?.info?.clear()

        var lineItemScreenHeader = LineItem(screenHeader as Screen, true, 0, TYPE_HEADER)
        var linItemScreenMoreInfo = LineItem(screenHeader.moreInfo, false, 0, TYPE_MORE_INFO)
        mLineItemList?.add(lineItemScreenHeader)
        mLineItemList?.add(linItemScreenMoreInfo)


        setupRecyclerView()
        //screen?.info.forEach {  }

//        textViewTitle.text = screen?.title
//        textViewInvestimentName.text = screen?.fundName
//        textViewWhatIs.text = screen?.whatIs
//        textViewDefinition.text = screen?.definition
//        textViewRiskDegree.text = screen?.riskTitle
    }

    override fun getInvestimentoError(error: String?) {

        mActivity?.showToast("${getString(R.string.url_error)}\n$error")
    }

    override fun onClickItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}