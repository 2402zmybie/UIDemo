package com.hzhztech.uidemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    //textView 最上显示的值
    //button5 左
    //button7  右
    //button9 确认
    //switch1
    //设置进度的progressbar progressBar3
    //editText
    //radioGroup  radiobutton1  radiobutton2
    //控制右边的 imageView
    //遇见  checkBox  checkBox2 checkBox3
    //评级 ratingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        button5.setOnClickListener { textView.text = resources.getString(R.string.button1) }
        button7.setOnClickListener { textView.text = resources.getString(R.string.button2) }
        switch1.setOnCheckedChangeListener { p0, p1 ->
            if(p1) {
                textView.text = "开"
            }else {
                textView.text = "关"
            }
        }
        //进度条 右边按钮的点击事件设置 左边的进度
        button9.setOnClickListener {
            var editTextStr = editText.text.toString().trim()
            if(editTextStr.isEmpty()) {
                toast("请输入设置进度条的数字")
            }else {
                var progressInt = editTextStr.toInt()
                progressBar3.progress = progressInt
                textView.text = editTextStr
            }
        }

        radioGroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                if(p1 == R.id.radioButton2) {
                    //android
                    textView.text = resources.getString(R.string.radiobutton1)
                    imageView.setImageResource(R.drawable.android)
                }else {
                    textView.text = resources.getString(R.string.radiobutton2)
                    imageView.setImageResource(R.drawable.apple)
                }
            }

        })

        initMeetCheckbox(checkBox,resources.getString(R.string.checkbox1))
        initMeetCheckbox(checkBox2,resources.getString(R.string.checkbox2))
        initMeetCheckbox(checkBox3,resources.getString(R.string.checkbox3))


        ratingBar.setOnRatingBarChangeListener { p0, p1, p2 ->
            if(p2) {
                textView.text = "评分" + p1.toString()
            }
        }
    }

    private fun initMeetCheckbox(checkBox: CheckBox, string: String?) {
        //遇见checkbox
        checkBox.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if(p1) {
                    //勾选
                    textView.text = string
                }
            }
        })
    }


}
