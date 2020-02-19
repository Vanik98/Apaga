package com.example.apaga.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.apaga.R

class DialogUtils {
    fun showConfirmationDialog(context: Context, title: String, message: String,
                              negativeClickListener: View.OnClickListener,
                               positiveClickListener: View.OnClickListener) {
        val dialog: Dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_confirmation_dialog)

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

        val btnNegative: Button = dialog.findViewById(R.id.btn_negative)
        if (negativeClickListener != null) {
            btnNegative.setOnClickListener(View.OnClickListener { v ->
                negativeClickListener.onClick(v)
                dialog.dismiss()
            })

        } else {
            btnNegative.setVisibility(View.GONE)
        }

        val btnPositive: Button = dialog.findViewById(R.id.btn_positive)
        btnPositive.setOnClickListener(View.OnClickListener { v ->
            if (positiveClickListener != null) {
                positiveClickListener.onClick(v)
            }
            dialog.dismiss()
        })

        dialog.show()

    }
}