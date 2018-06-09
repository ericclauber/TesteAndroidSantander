package com.example.eric.testeandroidsantander.investimentos.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.LineItem
import com.example.eric.testeandroidsantander.investimentos.InvestimentFragment
import com.example.eric.testeandroidsantander.utils.Utils
import com.example.eric.testeandroidsantander.webservices.investiments.*
import kotlinx.android.synthetic.main.line_item_investiment_fragment_down_info.view.*
import kotlinx.android.synthetic.main.line_item_investiment_fragment_info.view.*
import kotlinx.android.synthetic.main.line_item_investiment_fragment_more_info.view.*
import kotlinx.android.synthetic.main.line_item_investment_fragment_header.view.*
import kotlinx.android.synthetic.main.linear_layout_risk.view.*

/**
 * Created by eric on 03/06/18.
 */
class InvestmentHolder(var mContext: Context, itemView: View,
                       var mListener: InvestmentAdapter.OnClickListener) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(position: Int, item: LineItem) {

        when (item.type) {

            InvestimentFragment.TYPE_HEADER -> {

                val screen = item.obj as HeaderScreen

                itemView.textViewTitle.text = screen.title
                itemView.textViewInvestimentName.text = screen.fundName
                itemView.textViewWhatIs.text = screen.whatIs
                itemView.textViewDefinition.text = screen.definition
                itemView.textViewRiskDegree.text = screen.riskTitle
                itemView.textViewMoreInfoTitle.text = screen.infoTitle

                (itemView.linearLayoutRiskArrow.getChildAt(screen.risk - 1) as ImageView)
                        .setImageResource(R.drawable.baseline_keyboard_arrow_down_black_24)

                itemView.linearLayoutRiskView.getChildAt(screen.risk - 1)
                        .layoutParams.height = Utils.dpToPixel(mContext, 14)
            }
            InvestimentFragment.TYPE_MORE_INFO -> {

                val moreInfo = item.obj as MoreInfo

                itemView.textViewOnMonthFund.text = "${moreInfo.month.fund}%"
                itemView.textViewOnYearFund.text = "${moreInfo.year.fund}%"
                itemView.textViewOnTwelveMonthsFund.text = "${moreInfo.twelveMonths.fund}%"
                itemView.textViewOnMonthCDI.text = "${moreInfo.month.cdi}%"
                itemView.textViewOnYearCDI.text = "${moreInfo.year.cdi}%"
                itemView.textViewOnTwelveMonthsCDI.text = "${moreInfo.twelveMonths.cdi}%"
            }
            InvestimentFragment.TYPE_INFO -> {

                val info = item.obj as Info

                itemView.textViewInfoName.text = info.name
                itemView.textViewInfoData.text = info.data
            }
            InvestimentFragment.TYPE_DOWN_INFO -> {

                val downInfo = item.obj as DownInfo

                itemView.textViewInfoDownName.text = downInfo.name
            }
        }
    }
}