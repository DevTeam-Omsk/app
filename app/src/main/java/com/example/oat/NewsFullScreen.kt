package com.example.oat

import Objects.NewsItem
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_work_form.btnClose
import kotlinx.android.synthetic.main.activity_news_full_screen.*


class NewsFullScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_full_screen)
        val curNewsItem = intent.getSerializableExtra("CUR_NEWS_ITEM") as NewsItem
        tvNewsTitle.text = curNewsItem.title
        tvText.text = curNewsItem.text
        imageView.setImageResource(curNewsItem.preview)

        btnClose.setOnClickListener {
            finish()
        }

        if (Build.VERSION.SDK_INT < 19) {
            val v: View = this.window.decorView
            v.setSystemUiVisibility(View.GONE)
        } else {
            val decorView: View = window.decorView
            val uiOptions: Int = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            decorView.setSystemUiVisibility(uiOptions)
        }
    }
}