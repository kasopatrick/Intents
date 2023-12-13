package com.example.pillarmachine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var Mtitle :TextView
    lateinit var Jina : EditText
    lateinit var Pass : EditText
    lateinit var Ingia : Button
    lateinit var Kampuni : TextView
    lateinit var Hakuna : TextView
    lateinit var Neno : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Mtitle = findViewById(R.id.MtvTitle)
        Jina = findViewById(R.id.Mname)
        Pass = findViewById(R.id.Mpassword)
        Ingia = findViewById(R.id.Mbtnsign)
        Kampuni = findViewById(R.id.Mcompany)
        Hakuna = findViewById(R.id.Mhakuna)
        Neno = findViewById(R.id.Mtext)

        Ingia.setOnClickListener {
            var name = Jina.text.toString().trim()
            var Password = Pass.text.toString().trim()
            if (name.isEmpty()) {
                Jina.setError("Please enter this field")
                Jina.requestFocus()
            }else if (Password.isEmpty()){
                Pass.setError("Please enter this field")
                Pass.requestFocus()
            }else{
                var tembea = Intent(this,Homepg::class.java)
                startActivity(tembea)
            }

        }
        Hakuna.setOnClickListener {

        }




    }
}