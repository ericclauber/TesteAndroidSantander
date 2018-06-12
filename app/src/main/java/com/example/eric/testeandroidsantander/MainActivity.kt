package com.example.eric.testeandroidsantander

import android.os.Bundle
import android.view.View
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.enumbase.TypeButton
import com.example.eric.testeandroidsantander.contact.ContactFragment
import com.example.eric.testeandroidsantander.investiments.InvestimentFragment
import kotlinx.android.synthetic.main.layout_buttons_bottom.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    fun initUI() {

        contactButton.setOnClickListener(this)
        investmentButton.setOnClickListener(this)
        investmentButton.performClick()
    }

    fun initData() {}

    override fun onClick(v: View?) {

        when (v?.id) {

            investmentButton.id -> {

                val fragmentInvestimento = InvestimentFragment.getInstance()
                addFragment(fragmentInvestimento)
                configButtons(TypeButton.TYPE_INVESTIMENTO)
            }
            contactButton.id -> {

                val fragmentContato = ContactFragment.getInstance()
                addFragment(fragmentContato)
                configButtons(TypeButton.TYPE_CONTATO)
            }
        }
    }

    fun configButtons(type: TypeButton) {

        when (type) {

            TypeButton.TYPE_CONTATO -> {

                contactButton.isActivated = true
                investmentButton.isActivated = false
                view_investimento.visibility = View.INVISIBLE
                view_contato.visibility = View.VISIBLE
            }
            TypeButton.TYPE_INVESTIMENTO -> {

                investmentButton.isActivated = true
                contactButton.isActivated = false
                view_contato.visibility = View.INVISIBLE
                view_investimento.visibility = View.VISIBLE
            }
        }
    }
}
