package com.example.oat

import Objects.Lesson
import Objects.SettingsItem
import adapters.SettingsListAdapter
import android.app.AlertDialog
import android.app.Dialog
import android.nfc.Tag
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_hub.*
import kotlinx.android.synthetic.main.fragment_hub.view.*
import org.json.JSONObject
import java.lang.Exception
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Logger


@Suppress("UNREACHABLE_CODE")
class Hub : Fragment() {
    var items = ArrayList<SettingsItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_hub, container, false)
        val rwSettingsList = view?.findViewById<RecyclerView>(R.id.rwSettingsList)
        setSettingsItems()
        rwSettingsList?.layoutManager = LinearLayoutManager(context)
        rwSettingsList?.adapter = SettingsListAdapter(items, context)
        return view
    }

    private fun setSettingsItems() {
        items.add(SettingsItem(0, "Расписание", R.drawable.bell))
        items.add(SettingsItem(1, "Оценки", R.drawable.evaluation))
        items.add(SettingsItem(2, "Настройки", R.drawable.settings))
    }

}