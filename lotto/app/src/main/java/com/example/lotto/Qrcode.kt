package com.example.lotto

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.lotto.databinding.ActivityMainBinding
import com.example.lotto.databinding.ActivityQrcodeBinding
import com.google.zxing.integration.android.IntentIntegrator
import java.io.File

class Qrcode : AppCompatActivity() {
    private lateinit var binding: ActivityQrcodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        binding = ActivityQrcodeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        IntentIntegrator(this).initiateScan()
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)
        integrator.setPrompt("Scan a barcode")
        integrator.setCameraId(0) // Use a specific camera of the device

        integrator.setBeepEnabled(true)
        integrator.setBarcodeImageEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null){
            if (result.contents != null){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Cancled", Toast.LENGTH_SHORT).show()
            }
            if (result.barcodeImagePath != null){
                val bitmap = BitmapFactory.decodeFile(result.barcodeImagePath)
                binding.scannedImg.setImageBitmap(bitmap)
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data) // 다른 액티비티 가능성
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}