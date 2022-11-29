package com.smedialink.abakarmagomedov.githubapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar

/**
 * Created by abakarmagomedov on 15/05/17.
 */
abstract class BaseActivity : AppCompatActivity() {
    abstract var mProgressBar: ProgressBar?

    protected fun start(cls: Class<*>?, login: String?) {
        val intent = Intent(this, cls)
        intent.putExtra(Constants.LOGIN, login)
        startActivity(intent)
    }

    fun showProgress() {
        if (mProgressBar?.visibility != View.VISIBLE) {
            mProgressBar?.setVisibility(View.VISIBLE)
        }
    }

    fun hideProgress() {
        if (mProgressBar?.visibility == View.VISIBLE) {
            mProgressBar?.setVisibility(View.GONE)
        }
    }

    protected val errorDialog: AlertDialog
        protected get() {
            val builder = AlertDialog.Builder(this)
            builder.setPositiveButton(R.string.Ok) { dialog, which -> dialog.dismiss() }
            builder.setMessage(R.string.no_internet)
            return builder.create()
        }
}
