package com.example.eric.testeandroidsantander.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by eric on 19/05/18.
 */
open class BaseActivity : AppCompatActivity() {

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

    fun showToast(message : String?){

        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }
}