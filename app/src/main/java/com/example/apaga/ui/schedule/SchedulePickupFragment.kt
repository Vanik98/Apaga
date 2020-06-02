package com.example.apaga.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.TimePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.example.apaga.ui.home.HomeActivity
import com.example.apaga.utils.DialogUtils
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class SchedulePickupFragment : BaseFragment(),SchedulePickupContract.View {

    @Inject
    lateinit var presenter: SchedulePickupContract.Presenter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    @Inject
    lateinit var adapter: SchedulePickupAdapter
    @Inject
    lateinit  var dialogUtils: DialogUtils
    private lateinit var recyclerView: RecyclerView
    private lateinit var calendar:ImageView
    private lateinit var calendarText:TextView
    private lateinit var timePickerView: ImageView
    override fun findViewsById(view: View) {
        calendar = view.findViewById(R.id.schedule_pickup_iv_calendar)
        calendarText = view.findViewById(R.id.schedule_pickup_tv_calendar_text)
        timePickerView = view.findViewById(R.id.schedule_pickup_ed_time_picker)
    }

    override fun setViewsOnClickListener() {
        calendar.setOnClickListener{
            dialogUtils.showCalendar(activity as HomeActivity,calendarText)
        }
        timePickerView.setOnClickListener{
            dialogUtils.showTimePicker(activity as HomeActivity,calendarText)
        }

    }
    override fun setViewsOptions() {
        val curFormater = SimpleDateFormat("dd/MM/yyyy")
        val c = Calendar.getInstance().time
        val formattedDate:String = curFormater.format(c)
        calendarText.text = formattedDate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        val view = inflater.inflate(R.layout.fragment_schedule_pickup, container, false)
        val list : List<String> = arrayListOf("1","5","3","7")
        recyclerView = view.findViewById(R.id.schedule_pickup_rv_description)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
        recyclerView = view.findViewById(R.id.schedule_pickup_rv_bags)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(list)
        return view
    }
}
