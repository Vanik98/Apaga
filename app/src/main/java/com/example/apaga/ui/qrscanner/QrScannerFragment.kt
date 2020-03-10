package com.example.apaga.ui.qrscanner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import javax.inject.Inject


class QrScannerFragment  : BaseFragment(), QrScannerContract.View {

    @Inject
    lateinit var presenter:QrScannerContract.Presenter
    private lateinit var scanner:CodeScanner
    private lateinit var scannerView:CodeScannerView
    override fun setUp(view: View) {
        view.setOnClickListener{}

    }
    val fragmentContext = this
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_qr_scanner, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        scannerView = view.findViewById(R.id.qr_scanner_view)
        scannerView.isAutoFocusButtonVisible = false
        scannerView.isFlashButtonVisible = false
        scanner = activity?.let { CodeScanner(it,scannerView) }!!
        scanner.setDecodeCallback {
            Log.i("vvv",it.text)
            activity!!.runOnUiThread{

        }
            scannerView.setOnClickListener{
                scanner.startPreview()
            }
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        scanner.startPreview()
    }

     override fun onPause() {
        scanner.releaseResources()
        super.onPause()
    }


}
