package com.example.eric.testeandroidsantander.investiments.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.LineItem
import com.example.eric.testeandroidsantander.investiments.InvestimentFragment

/**
 * Created by eric on 03/06/18.
 */
class InvestmentAdapter(val mContext: Context,
                        internal var mListener: OnClickListener,
                        var mLineItemList: MutableList<LineItem>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mLineItem: MutableList<LineItem>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View? = null

        when (viewType) {
            InvestimentFragment.TYPE_HEADER -> {

                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.line_item_investment_fragment_header, parent, false)
            }

            InvestimentFragment.TYPE_MORE_INFO -> {

                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.line_item_investiment_fragment_more_info, parent, false)
            }
            InvestimentFragment.TYPE_INFO -> {

                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.line_item_investiment_fragment_info, parent, false)
            }

            InvestimentFragment.TYPE_DOWN_INFO -> {

                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.line_item_investiment_fragment_down_info, parent, false)
            }
        }

        return InvestmentHolder(mContext, view!!, mListener)
    }

    override fun getItemCount(): Int {

        return mLineItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as InvestmentHolder).bindItem(position, mLineItemList.get(position))
    }

    override fun getItemViewType(position: Int): Int {

        return mLineItemList.get(position).type
    }

    interface OnClickListener {

        fun onClickItem()
    }
}