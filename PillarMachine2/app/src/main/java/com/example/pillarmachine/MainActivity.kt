package com.example.morningintents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    //instantiate the user interface element
    lateinit var mBtnSms: Button
    lateinit var mBtnEmail: Button
    lateinit var mBtnCamera:Button
    lateinit var mBtnShare: Button
    lateinit var mBtnMpesa: Button
    lateinit var mBtnCall: Button
    lateinit var mBtnWebsite: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtnSms = findViewById(R.id.mBtnSms)
        mBtnEmail = findViewById(R.id.mBtnEmail)
        mBtnCamera = findViewById(R.id.mBtnCamera)
        mBtnShare = findViewById(R.id.mBtnShare)
        mBtnMpesa = findViewById(R.id.mBtnMpesa)
        mBtnCall = findViewById(R.id.mBtnCall)
        mBtnWebsite = findViewById(R.id.mBtnWebsite)

        mBtnSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0728474931")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there....")
            startActivity(intent)

        }
        mBtnEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "kasopatrick5@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir ....")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        mBtnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }
        mBtnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)


        }
        mBtnMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        mBtnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0114434236"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        mBtnWebsite.setOnClickListener {
            val tembea = Intent(this@MainActivity,WebsiteActivity::class.java)
            startActivity(tembea)

        }

    }
}