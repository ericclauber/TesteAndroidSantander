package com.example.eric.testeandroidsantander.investiments

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
import com.example.eric.testeandroidsantander.investiments.adapter.InvestmentAdapter
import com.example.eric.testeandroidsantander.webservices.investiments.HeaderScreen
import com.example.eric.testeandroidsantander.webservices.investiments.Screen
import kotlinx.android.synthetic.main.fragment_investiment.*

/**
 * Created by eric on 27/05/18.
 */
class InvestimentFragment : Fragment(), InvestimentView, InvestmentAdapter.OnClickListener,
        View.OnClickListener {

    var investimentoPresenterImpl: InvestimentoPresenterImpl? = null
    var mActivity: MainActivity? = null
    var mInvestmentAdapter: InvestmentAdapter? = null
    var mLineItemList: MutableList<LineItem> = ArrayList()


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

        val rooView = inflater.inflate(R.layout.fragment_investiment, container, false)
        return rooView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initData()
    }

    fun initUI() {

        mActivity = (activity as MainActivity)
        imageViewUpload.setOnClickListener(this)
        investButton.setOnClickListener(this)
    }

    fun initData() {

        investimentoPresenterImpl = InvestimentoPresenterImpl(context!!, this)
        investimentoPresenterImpl?.getScreen(context!!)

        setupRecyclerView()
    }

    fun setupRecyclerView() {

        mInvestmentAdapter = InvestmentAdapter(context!!, this, mLineItemList!!)

        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerViewInvestment.setHasFixedSize(true)
        recyclerViewInvestment.layoutManager = llm

        recyclerViewInvestment.adapter = mInvestmentAdapter
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            imageViewUpload.id -> {

                mActivity?.showToast(resources.getString(R.string.upload_button_investiment))
            }
            investButton.id -> {

                mActivity?.showToast(resources.getString(R.string.invest_button_investiment))
            }
        }
    }

    override fun onClickItem() {

        mActivity?.showToast(resources.getString(R.string.download_item_down_info_investiment))
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

        val headerScreen = HeaderScreen(screen!!.title, screen.fundName, screen.whatIs,
                screen.definition, screen.riskTitle, screen.risk, screen.infoTitle)

        val lineItemHeaderScreen = LineItem(headerScreen, true, 0, TYPE_HEADER)
        val linItemMoreInfoScreen = LineItem(screen.moreInfo, false, 0, TYPE_MORE_INFO)
        mLineItemList?.add(lineItemHeaderScreen)
        mLineItemList?.add(linItemMoreInfoScreen)

        screen?.info?.forEach { info ->

            var lineItemInfo = LineItem(info, false, 0, TYPE_INFO)
            mLineItemList?.add(lineItemInfo)
        }
        screen?.downInfo?.forEach { downInfo ->

            var lineItemInfo = LineItem(downInfo, false, 0, TYPE_DOWN_INFO)
            mLineItemList?.add(lineItemInfo)
        }

        mInvestmentAdapter?.notifyDataSetChanged()
    }

    override fun getInvestimentoError(error: String?) {

        mActivity?.showToast("${getString(R.string.url_error)}\n$error")
    }
}