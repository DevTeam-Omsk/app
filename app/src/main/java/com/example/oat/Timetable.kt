package com.example.oat

import adapters.Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
import com.example.oat.R
import com.google.android.material.tabs.TabLayout
import news_screens.Common_news
import news_screens.News_lenta
import timetable_screens.Today
import timetable_screens.Tommorow
import timetable_screens.Week

class Timetable : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_timetable, container, false)

        // устанавливаю анимацию
        val tabs = view.findViewById<View>(R.id.result_tabs) as TabLayout
        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.tabs_anim)
        tabs.startAnimation(animation)

        // устанавливаю ViewPager чтобы можно было сфайпать

        val viewPager = view.findViewById<View>(R.id.viewPager) as ViewPager
        setupViewPager(viewPager)
        // Set Tabs inside Toolbar
        tabs.setupWithViewPager(viewPager)

        return view
    }


    // Add Fragments to Tabs
    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(childFragmentManager)
        adapter.addFragment(Today(), "Сегодня")
        adapter.addFragment(Tommorow(), "Завтра")
        adapter.addFragment(Week(), "Неделя")
        viewPager.adapter = adapter
    }
}