package com.example.apaga.ui.schedule

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.address.AddressActivity
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.utils.DialogUtils
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class SchedulePickupFragment : BaseFragment(), SchedulePickupContract.View {

    @Inject
    lateinit var presenter: SchedulePickupContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: SchedulePickupAdapter
    @Inject
    lateinit var dialogUtils: DialogUtils
    private lateinit var recyclerView: RecyclerView
    private lateinit var calendar: ImageView
    private lateinit var calendarText: TextView
    private lateinit var timePickerView: ImageView
    private lateinit var timePickerT1: EditText
    private lateinit var timePickerT2: EditText
    private lateinit var addBtn: Button
    private lateinit var confirmBtn: Button
    private lateinit var closeBtn: Button
    private lateinit var cancelBtn: Button
    override fun findViewsById(view: View) {
        calendar = view.findViewById(R.id.schedule_pickup_iv_calendar)
        calendarText = view.findViewById(R.id.schedule_pickup_tv_calendar_text)
        timePickerView = view.findViewById(R.id.schedule_pickup_ed_time_picker_view)
        timePickerT1 = view.findViewById(R.id.schedule_pickup_ed_time_picker_t1)
        timePickerT2 = view.findViewById(R.id.schedule_pickup_ed_time_picker_t2)
        addBtn = view.findViewById(R.id.schedule_pickup_btn_add)
        confirmBtn = view.findViewById(R.id.schedule_pickup_btn_confirm)
        closeBtn = view.findViewById(R.id.schedule_pickup_btn_close)
        cancelBtn = view.findViewById(R.id.schedule_pickup_btn_cancel)
        recyclerView = view.findViewById(R.id.schedule_pickup_rv_description)
    }

    override fun setViewsOnClickListener() {
        calendar.setOnClickListener {
            dialogUtils.showCalendar(activity as HomeActivity, calendarText)
        }
        timePickerView.setOnClickListener {
            dialogUtils.showTimePicker(activity as HomeActivity, timePickerT1, timePickerT2)
        }
        addBtn.setOnClickListener {
            openAddressActivity()
        }
        confirmBtn.setOnClickListener {
            //call
        }
        closeBtn.setOnClickListener {
            (activity as HomeActivity).navigate(R.id.nav_dashboard)
        }
        cancelBtn.setOnClickListener {
            //call
        }
    }

    private fun openAddressActivity() {
        startActivity(Intent(activity, AddressActivity::class.java))
        activity!!.finish()
    }

    @SuppressLint("SimpleDateFormat")
    override fun setViewsOptions() {
        var curFormater = SimpleDateFormat("dd/MM/yyyy")
        var c = Calendar.getInstance().time
        var formattedDate: String = curFormater.format(c)
        calendarText.text = formattedDate
        formattedDate = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date());
        timePickerT1.setText(formattedDate)
        timePickerT2.setText(formattedDate)
        val list: List<String> = arrayListOf("1", "5", "3", "7")
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
        recyclerView = view!!.findViewById(R.id.schedule_pickup_rv_bags)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        val view = inflater.inflate(R.layout.fragment_schedule_pickup, container, false)
        return view
    }
}
