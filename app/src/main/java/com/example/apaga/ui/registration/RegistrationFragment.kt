package com.example.apaga.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apaga.R
import com.example.apaga.data.db.model.User
import com.example.apaga.data.network.model.NotificationType
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject


class RegistrationFragment : BaseFragment(), RegistrationContract.View {
    @Inject
    lateinit var presenter: RegistrationContract.Presenter
    private lateinit var userName:EditText
    private lateinit var phoneNumber:EditText
    private lateinit var password:EditText
    private lateinit var email:EditText
    private lateinit var agreed:CheckBox
    private lateinit var register:Button

    override fun findViewsById(view: View) {
        userName = view.findViewById(R.id.registration_et_name)
        phoneNumber = view.findViewById(R.id.registration_et_phone)
        password = view.findViewById(R.id.registration_et_password)
        email = view.findViewById(R.id.registration_et_email)
//        organizationRV = view.findViewById(R.id.registration_rv_organization)
        agreed = view.findViewById(R.id.registration_cb_agreed)
        register = view.findViewById(R.id.registration_btn_register)
    }

    override fun setViewsOnClickListener() {
        register.setOnClickListener{
            presenter.registration(User())
        }
    }

    override fun setViewsOptions() {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view
    }


}
