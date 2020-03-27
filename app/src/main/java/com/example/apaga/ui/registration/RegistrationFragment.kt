package com.example.apaga.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject


class RegistrationFragment : BaseFragment(),RegistrationContract.View {
    @Inject
    lateinit var presenter:RegistrationContract.Presenter

    override fun setUp(view: View) {

        activityComponent!!.inject(this)
        presenter.onAttach(this)
    }

    override fun findViewsById(view: View) {
        view.setOnClickListener{} }

    override fun setViewsOnClickListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewsOptions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        actionWithViews(view)
        return view
    }




}
