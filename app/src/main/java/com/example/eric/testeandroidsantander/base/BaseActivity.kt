package com.example.eric.testeandroidsantander.base

import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.eric.testeandroidsantander.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by eric on 19/05/18.
 */
open class BaseActivity : AppCompatActivity() {

    fun addFragment(fragment: Fragment) {

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.javaClass.simpleName)
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .addToBackStack(null)
                .commit()
    }

    /*fun onLoadingStart() {
       onLoadingFinish()
       progressDialog = ProgressDialog(this@BaseActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
       progressDialog!!.setMessage(getString(R.string.title_wait))
       progressDialog!!.setCancelable(false)

       try {
           progressDialog!!.show()
       } catch (e: Exception) {
           e.printStackTrace()
       }
   } */

    fun showToast(message: String?) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun configButtons(type: TypeButton) {

        when (type) {

            TypeButton.TYPE_CONTATO -> {
                button_contato.setBackgroundColor(resources.getColor(R.color.colorButtonSelected, resources.newTheme()))
                button_contato.height = button_contato.height + 4
                button_investimento.setBackgroundColor(resources.getColor(R.color.colorButtonNormal, resources.newTheme()))
            }
            TypeButton.TYPE_INVESTIMENTO -> {
                button_investimento.setBackgroundColor(resources.getColor(R.color.colorButtonSelected, resources.newTheme()))
                button_contato.setBackgroundColor(resources.getColor(R.color.colorButtonNormal, resources.newTheme()))
            }
        }
    }
}