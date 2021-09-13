package com.example.fifthproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.first.*
import java.lang.Exception

class First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first)

        btn_questions.setOnClickListener {
            val intent =Intent(this,Second::class.java)
            startActivity(intent)
        }
        btn_rate.setOnClickListener {
            try{
                var uri=Uri.parse("market://details?id $packageName")
                val intent=Intent(Intent.ACTION_VIEW)
                intent.data=uri
                startActivity(intent)
            }catch(ex:Exception){
                var uri=Uri.parse("http://play.google.com/store/apps/details?id $packageName")
                val intent=Intent(Intent.ACTION_VIEW)
                intent.data=uri
                startActivity(intent)
            }

        }
    }
}