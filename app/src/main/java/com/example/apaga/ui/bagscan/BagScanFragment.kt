package com.example.apaga.ui.bagscan

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.example.apaga.R
import com.example.apaga.ui.base.BaseFragment
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.util.jar.Manifest
import javax.inject.Inject


class BagScanFragment : BaseFragment(), BagScanContract.View {

    @Inject
    lateinit var presenter: BagScanContract.Presenter
    private lateinit var scanner: CodeScanner
    private lateinit var scannerView: CodeScannerView
    private lateinit var bagIdBtn: Button
    private lateinit var noQrCodeBtn: Button
    private lateinit var bgIdText: EditText

    override fun findViewsById(view: View) {
        scannerView = view.findViewById(R.id.bag_scan_qr_scanner_view)
        bagIdBtn = view.findViewById(R.id.bag_scan_btn_bag_id)
        noQrCodeBtn = view.findViewById(R.id.bag_scan_btn_no_qr)
        bgIdText = view.findViewById(R.id.bag_scan_ed_id)
    }

    override fun setViewsOptions() {
        scannerView.isAutoFocusButtonVisible = false
        scannerView.isFlashButtonVisible = false
        scanner = activity?.let { CodeScanner(it, scannerView) }!!
        scanner.setDecodeCallback {
            Log.i("vvv", it.text)
            activity!!.runOnUiThread {
                bgIdText.setText(it.text)
            }
            scannerView.setOnClickListener {
                scanner.startPreview()
            }
        }
        bagIdBtn.setOnClickListener {


        }
        noQrCodeBtn.setOnClickListener {

        }
    }

    private fun requestForCamera() {
        Dexter.withActivity(activity).withPermission(android.Manifest.permission.CAMERA).withListener(
                object : PermissionListener {
                    override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                        scanner.startPreview()
                    }

                    override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, token: PermissionToken?) {
                        token!!.continuePermissionRequest()
                    }

                    @SuppressLint("ShowToast")
                    override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                        Toast.makeText(context, getString(R.string.camera_permisson_text), Toast.LENGTH_SHORT)
                    }
                }
        ).check()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_bag_scan, container, false)
        activityComponent!!.inject(this)
        presenter.onAttach(this)
        return view
    }

    override fun onResume() {
        super.onResume()
        requestForCamera()
    }

    override fun onPause() {
        scanner.releaseResources()
        super.onPause()
    }


}
