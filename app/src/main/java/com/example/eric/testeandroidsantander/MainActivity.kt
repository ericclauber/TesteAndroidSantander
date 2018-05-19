package com.example.eric.testeandroidsantander

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eric.testeandroidsantander.base.BaseActivity
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.contato.ContatoPresenterImpl
import com.example.eric.testeandroidsantander.contato.ContatoView
import com.example.eric.testeandroidsantander.webservices.contato.Cells

class MainActivity : BaseActivity(), ContatoView {

    var contatoPresenterImpl: ContatoPresenterImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contatoPresenterImpl = ContatoPresenterImpl(this, this)
        contatoPresenterImpl?.getCells(this)
    }

    override fun showProgress(type: BaseView.ProgressType) {

    }

    override fun hideProgress() {

    }

    override fun onConnectionFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCellsSuccess(cells: MutableList<Cells>) {

        cells.forEach {

            Log.d("TAG", "> > > > > > > > ${it.message}")
        }
    }

    override fun getCellsError(error: String?) {

        showToast(error)
    }
}
