package com.example.eric.testeandroidsantander

import android.os.Bundle
import android.view.View
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.TypeButton
import com.example.eric.testeandroidsantander.contato.ContatoFragment
import kotlinx.android.synthetic.main.activity_main.*

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

            }
            R.id.button_contato -> {

                val fragmentContato = ContatoFragment.getInstance()
                addFragment(fragmentContato)
                configButtons(TypeButton.TYPE_CONTATO)
            }
        }
    }
}
