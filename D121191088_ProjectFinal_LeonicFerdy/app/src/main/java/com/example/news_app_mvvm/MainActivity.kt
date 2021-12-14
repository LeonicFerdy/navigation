package com.example.news_app_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news_app_mvvm.UI.ListNews.AllNewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrame, AllNewsFragment.newInstance())
            .commitNow()

    }

}