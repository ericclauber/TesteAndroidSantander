package com.example.eric.testeandroidsantander

import android.os.Bundle
import android.view.View
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.enumbase.TypeButton
import com.example.eric.testeandroidsantander.contato.ContatoFragment
import com.example.eric.testeandroidsantander.investiments.InvestimentFragment
import kotlinx.android.synthetic.main.layout_buttons_bottom.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    fun initUI() {

        button_contato.setOnClickListener(this)
        button_contato.performClick()
        button_investimento.setOnClickListener(this)
    }

    fun initData() {}

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.button_investimento -> {

                val fragmentInvestimento = InvestimentFragment.getInstance()
                addFragment(fragmentInvestimento)
                configButtons(TypeButton.TYPE_INVESTIMENTO)
            }
            R.id.button_contato -> {

                val fragmentContato = ContatoFragment.getInstance()
                addFragment(fragmentContato)
                configButtons(TypeButton.TYPE_CONTATO)
            }
        }
    }

    fun configButtons(type: TypeButton) {

        when (type) {

            TypeButton.TYPE_CONTATO -> {

                button_contato.isActivated = true
                button_investimento.isActivated = false
                view_investimento.visibility = View.INVISIBLE
                view_contato.visibility = View.VISIBLE
            }
            TypeButton.TYPE_INVESTIMENTO -> {

                button_investimento.isActivated = true
                button_contato.isActivated = false
                view_contato.visibility = View.INVISIBLE
                view_investimento.visibility = View.VISIBLE
            }
        }
    }
}
