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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCellsSuccess(cells: MutableList<Cells>) {

        val constraintSet = ConstraintSet()

        val constraintLayoutParams = ConstraintLayout
                .LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT)

        val linearLayoutParams = LinearLayout
                .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)

        val salutation = TextView(context)

        cells.forEach { cell ->

            when (cell.type) {

                Type.TEXT.type -> {

                    salutation.id = cell.id
                    salutation.text = cell.message
                    salutation.setTextColor(resources.getColor(R.color.colorBlack))
                    salutation.layoutParams = constraintLayoutParams
                    constraintContactFragmet.addView(salutation)

                    constraintSet.clone(constraintContactFragmet)

                    constraintSet.connect(salutation.id, ConstraintSet.TOP, constraintContactFragmet.id,
                            ConstraintSet.TOP, Utils.dpToPixel(context!!, cell.topSpacing.toInt()))
                    constraintSet.connect(salutation.id, ConstraintSet.LEFT, constraintContactFragmet.id,
                            ConstraintSet.LEFT)
                    constraintSet.connect(salutation.id, ConstraintSet.RIGHT, constraintContactFragmet.id,
                            ConstraintSet.RIGHT)
                }
                Type.FIELD.type -> {

                    when (cell?.typefield) {

                        TypeField.TEXT.typeField.toString() -> {

                            val inputTypeName = TextInputLayout(context)
                            inputTypeName.id = View.generateViewId()
                            inputTypeName.background = resources.getDrawable(R.color.colorBlack)
                            inputTypeName.layoutParams = constraintLayoutParams

                            val editTextName = EditText(context)
                            editTextName.id = cell.id
                            editTextName.hint = cell.message
                            editTextName.layoutParams = linearLayoutParams
                            inputTypeName.addView(editTextName)
                            constraintContactFragmet.addView(inputTypeName)

//                            constraintSet.clone(constraintContactFragmet)

                            constraintSet.connect(inputTypeName.id, ConstraintSet.TOP, salutation.id,
                                    ConstraintSet.BOTTOM, Utils.dpToPixel(context!!, cell.topSpacing.toInt()))
                            constraintSet.connect(inputTypeName.id, ConstraintSet.LEFT, constraintContactFragmet.id,
                                    ConstraintSet.LEFT)
                            constraintSet.connect(inputTypeName.id, ConstraintSet.RIGHT, constraintContactFragmet.id,
                                    ConstraintSet.RIGHT)
                        }

                        TypeField.EMAIL.typeField.toString() -> {

                        }

                        "telnumber" -> {
                        }
                    }
                }
            }
        }
        constraintSet.applyTo(constraintContactFragmet)
    }

    override fun getCellsError(error: String?) {

        mActivity?.showToast("${getString(R.string.url_error)}\n$error")
    }
}