package com.example.eric.testeandroidsantander.investimentos.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.LineItem
import com.example.eric.testeandroidsantander.investimentos.InvestimentFragment
import com.example.eric.testeandroidsantander.utils.Utils
import com.example.eric.testeandroidsantander.webservices.investimentos.Screen
import kotlinx.android.synthetic.main.line_item_investment_fragment_head.view.*
import kotlinx.android.synthetic.main.linear_layout_risk.view.*

/**
 * Created by eric on 03/06/18.
 */
class InvestmentHolder(var mContext: Context, itemView: View,
                       var mListener: InvestmentAdapter.OnClickListener) : RecyclerView.ViewHolder(itemView) {
//
//    internal var textViewInvestimentName = itemView.findViewById<TextView>(R.id.textViewTitle)
//    internal var textViewInvestimentName=itemView.findViewById<TextView>(R.id.textViewInvestimentName)

    fun bindItem(position: Int, item: LineItem) {

        when (item.type) {
            InvestimentFragment.TYPE_HEADER -> {

                var screen = item.obj as Screen

                itemView.textViewTitle.text = screen.title
                itemView.textViewInvestimentName.text = screen.fundName
                itemView.textViewWhatIs.text = screen.whatIs
                itemView.textViewDefinition.text = screen.definition
                itemView.textViewRiskDegree.text = screen.riskTitle

                (itemView.linearLayoutRiskArrow.getChildAt(screen.risk - 1) as ImageView)
                        .setImageResource(R.drawable.baseline_keyboard_arrow_down_black_24)

                itemView.linearLayoutRiskView.getChildAt(screen.risk - 1)
                        .layoutParams.height = Utils.dpToPixel(mContext, 14)


            }
        }
    }
}