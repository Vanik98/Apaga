package com.example.apaga.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.example.apaga.R
import javax.inject.Inject

class DialogUtils @Inject constructor(private val dialog:Dialog){

    fun showConfirmationDialog(context: Context, title: String?, message: String?,
                               negativeClickListener: View.OnClickListener?,
                               positiveClickListener: View.OnClickListener?) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_custom_confirmation)

        if (dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        val txtTitle: TextView = dialog.findViewById(R.id.txt_title)
        val txtMessage: TextView = dialog.findViewById(R.id.txt_msg)

        if (TextUtils.isEmpty(title)) {
            txtTitle.visibility = View.GONE

        } else {
            txtTitle.text = title
        }
        txtMessage.text = message

        val btnNegative: TextView = dialog.findViewById(R.id.btn_negative)
        if (negativeClickListener != null) {
            btnNegative.setOnClickListener(View.OnClickListener { v ->
                negativeClickListener.onClick(v)
                dialog.dismiss()
            })

        } else {
            btnNegative.visibility = View.GONE
        }

        val btnPositive: TextView = dialog.findViewById(R.id.btn_positive)
        btnPositive.setOnClickListener(View.OnClickListener { v ->
            if (positiveClickListener != null) {
                positiveClickListener.onClick(v)
            }
            dialog.dismiss()
        })

        dialog.show()

    }

    fun showProgressBar() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_loading_progressbar)

        if (dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog.show()
    }
    fun dialogDismis(){
        if(dialog.isShowing){
            dialog.dismiss()
        }
    }
}