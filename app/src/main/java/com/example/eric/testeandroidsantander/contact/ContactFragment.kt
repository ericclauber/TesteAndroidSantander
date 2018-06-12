package com.example.eric.testeandroidsantander.contact

import android.content.res.ColorStateList
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.eric.testeandroidsantander.MainActivity
import com.example.eric.testeandroidsantander.R
import com.example.eric.testeandroidsantander.base.BaseView
import com.example.eric.testeandroidsantander.base.enumbase.Type
import com.example.eric.testeandroidsantander.base.enumbase.TypeField
import com.example.eric.testeandroidsantander.utils.Utils
import com.example.eric.testeandroidsantander.webservices.contact.Cells
import kotlinx.android.synthetic.main.fragment_contact.*

/**
 * Created by eric on 20/05/18.
 */
class ContactFragment : Fragment(), ContactView {

    var contatoPresenterImpl: ContatoPresenterImpl? = null
    var mActivity: MainActivity? = null

    companion object {

        fun getInstance(): ContactFragment {

            val fragment = ContactFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_contact, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        initData()
    }

    fun initUI() {

        mActivity = (activity as MainActivity)
    }

    fun initData() {

        contatoPresenterImpl = ContatoPresenterImpl(context!!, this)
        contatoPresenterImpl?.getCells(context!!)
    }

    override fun showProgress(type: BaseView.ProgressType) {

        mActivity?.onLoadingStart()
    }

    override fun hideProgress() {

        mActivity?.onLoadingFinish()
    }

    override fun onConnectionFailed() {

        // TODO
    }

    override fun getCellsSuccess(cells: MutableList<Cells>) {

        mActivity?.showToast("Carregado com sucesso...")
    }

    override fun getCellsError(error: String?) {

        mActivity?.showToast("${getString(R.string.url_error)}\n$error")
    }
}