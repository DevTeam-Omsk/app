package com.example.oat

import adapters.Adapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import news_screens.Common_news
import news_screens.News_lenta


class News : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_news, container, false)
//        val tabs = view.findViewById<View>(R.id.result_tabs) as TabLayout
//
//        val animation: Animation = AnimationUtils.loadAnimation(context, R.anim.tabs_anim)
//        tabs.startAnimation(animation)
//
//        val viewPager = view.findViewById<View>(R.id.viewPager) as ViewPager
//        setupViewPager(viewPager)
//        // Set Tabs inside Toolbar
//        tabs.setupWithViewPager(viewPager)

        return view
    }

    // Add Fragments to Tabs
    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(childFragmentManager)
        adapter.addFragment(Common_news(), title = "Важное")
        adapter.addFragment(News_lenta(), "Лента")
        viewPager.adapter = adapter
    }
}