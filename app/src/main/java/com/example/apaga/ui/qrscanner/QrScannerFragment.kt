package com.example.apaga.ui.qrscanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.google.zxing.Result
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.lang.reflect.Executable
import javax.inject.Inject


class QrScannerFragment  : BaseFragment(), QrScannerContract.View, ZXingScannerView.ResultHandler {

    @Inject
    lateinit var presenter:QrScannerContract.Presenter
    private lateinit var scannerView:ZXingScannerView
    override fun setUp(view: View) {
        view.setOnClickListener{}

    }
    val cc =this
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_qr_scanner, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        scannerView = view.findViewById(R.id.qr_scanner_view)

        Dexter.withActivity(activity)
                .withPermission(android.Manifest.permission.CAMERA)
                .withListener(object : PermissionListener{
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                         scannerView.setResultHandler(cc)
                         scannerView.startCamera()
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?, token: PermissionToken?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
                .check()
        return view
    }


    override fun onDestroy() {
        scannerView.stopCamera()
        super.onDestroy()
    }

    override fun handleResult(rawResult: Result?) {
        print("ara xi")
    }


}
