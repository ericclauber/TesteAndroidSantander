package com.example.eric.testeandroidsantander.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.eric.testeandroidsantander.R

/**
 * Created by eric on 19/05/18.
 */
open class BaseActivity : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    fun addFragment(fragment: Fragment) {

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.javaClass.simpleName)
                .setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                .addToBackStack(null)
                .commit()
    }

    fun onLoadingStart() {
        onLoadingFinish()

        progressDialog = ProgressDialog(this@BaseActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
        progressDialog!!.setMessage(getString(R.string.text_wait_progress_dialog))
        progressDialog!!.setCancelable(false)

        try {
            progressDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onLoadingFinish() {

        if (progressDialog != null) {

            progressDialog?.dismiss()
            progressDialog = null
        }
    }

    fun showToast(message: String?) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {}
}