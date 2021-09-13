package com.example.fifthproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.second.*
import java.lang.Exception
import java.util.*

class Second : AppCompatActivity() {

    private var valQue:Array<String>?=null
    private var valAns:Array<String>?=null
    private var index=0
    var tos:TextToSpeech?=null
    var res=0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        valQue=resources.getStringArray(R.array.que)
        valAns=resources.getStringArray(R.array.ans)
        tv_score.text="${index+1}/${valQue!!.size}"
        tv_question.text=valQue!![index]


        tos= TextToSpeech(this,object: TextToSpeech.OnInitListener{
            override fun onInit(p0: Int) {
                res=tos!!.setLanguage(Locale.ENGLISH)
            }

        })
    }
    fun btnAction(view:View){
        when(view.id)
        {
            R.id.btn_prev->{
                tv_answer.setText(R.string.tv_answer)
                try{
                    index--
                    tv_score.text="${index+1}/${valQue!!.size}"
                    tv_question.text=valQue!![index]
                }catch (ex:Exception){
                    index=(valQue!!.size)-1
                    tv_score.text="${index+1}/${valQue!!.size}"
                    tv_question.text=valQue!![index]
                }

            }
            R.id.btn_help->{
                tv_answer!!.text=valAns!![index]
            }
            R.id.btn_next->{
                tv_answer.setText(R.string.tv_answer)
                try{
                    index++
                    tv_score.text="${index+1}/${valQue!!.size}"
                    tv_question.text=valQue!![index]
                }catch (ex:Exception){
                    index=0
                    tv_score.text="${index+1}/${valQue!!.size}"
                    tv_question.text=valQue!![index]
                }

            }
            R.id.btn_voice->{
                if(res==TextToSpeech.LANG_NOT_SUPPORTED || res==TextToSpeech.LANG_MISSING_DATA){
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                }else{
                    tos!!.speak(tv_question.text,TextToSpeech.QUEUE_FLUSH,null,null)
                }

            }
        }
    }
}