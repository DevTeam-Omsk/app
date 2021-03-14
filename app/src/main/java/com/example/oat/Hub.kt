package com.example.oat

import android.app.AlertDialog
import android.app.Dialog
import android.nfc.Tag
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.DialogFragment
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



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hub, container, false)


    }

}