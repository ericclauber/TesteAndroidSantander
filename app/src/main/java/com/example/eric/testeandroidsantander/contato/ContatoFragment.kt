package com.example.eric.testeandroidsantander.contato

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eric.testeandroidsantander.MainActivity
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.webservices.contato.Cells

/**
 * Created by eric on 20/05/18.
 */
class ContatoFragment : Fragment(), ContatoView {

    var contatoPresenterImpl: ContatoPresenterImpl? = null
    var mActivity : MainActivity? = null

    companion object {

        fun getInstance() : ContatoFragment {

            val fragment = ContatoFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_contato, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initData()
    }

    fun initUI(){

        var mActivity = (activity as MainActivity)
    }

    fun initData(){

        contatoPresenterImpl = ContatoPresenterImpl(context!!, this)
        contatoPresenterImpl?.getCells(context!!)
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

        mActivity?.showToast(error)
    }
}