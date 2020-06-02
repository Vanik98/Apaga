package com.example.apaga.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import com.example.apaga.R
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.min

class DialogUtils @Inject constructor(private val dialog: Dialog) {

    fun showConfirmationDialog(context: Context, title: String?, message: String?,
                               negativeClickListener: View.OnClickListener?,
                               positiveClickListener: View.OnClickListener?) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_apaga_custom_confirmation)

        if (dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        val txtTitle: TextView = dialog.findViewById(R.id.txt_title)
        val txtMessage: TextView = dialog.findViewById(R.id.txt_msg)
        val txtEmail: TextView = dialog.findViewById(R.id.txt_email)
        val txtFb: TextView = dialog.findViewById(R.id.txt_fb)
        val txtPhone: TextView = dialog.findViewById(R.id.txt_phone)

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

    fun showCalendar(context: Context, calendarText: TextView) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_calendar)
        if (dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.show()
        val calendarView: CalendarView = dialog.findViewById(R.id.calendarView)
            calendarView.setOnDateChangeListener { p0, p1, p2, p3 ->
                    var day = "$p3"
                    var mount  = if(p2<9){
                        "0${p2+1}"
                    }else{
                        "${p2+1}"
                    }

                    var year = p1
                calendarText.text = "$day/$mount/$year"
                    dialog.dismiss()
            }
    }

    @SuppressLint("ShowToast")
    fun showTimePicker(context: Context, t1: EditText, t2:EditText) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_time_picker)
        if (dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.show()
        var time1 = 0
        var time2 =0
        var minute = ""
        val timePicer1:TimePicker = dialog.findViewById(R.id.timePicker1)
        val timePicer2:TimePicker = dialog.findViewById(R.id.timePicker2)
        timePicer1.setOnTimeChangedListener { p0, p1, p2 ->
             minute  = if(p2<10){
                "0$p2"
            }else{
                "$p2"
            }

            t1.setText("$p1:$minute")
            time1 = p1
        }
        timePicer2.setOnTimeChangedListener { p0, p1, p2 ->
              minute = if(p2<10){
                "0$p2"
            }else{
                "$p2"
              }
                t2.setText("$p1:$minute")
            time2 = p1
        }
        val  confirm :Button = dialog.findViewById(R.id.time_picker_confirm)
        confirm.setOnClickListener{
            if(time2 - time1 >=3){
                dialog.dismiss()
            }else{
                Toast.makeText(context,context.getString(R.string.min_int_3),Toast.LENGTH_SHORT)
            }
        }

    }

    fun dialogDismis() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }
}