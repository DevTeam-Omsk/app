package com.example.oat

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.content.DialogInterface
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.loader.content.AsyncTaskLoader
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_hub.*
import kotlinx.android.synthetic.main.fragment_hub.view.*
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val bnController = findNavController(findViewById(R.id.fragment))
        bottom_nav.setupWithNavController(bnController)


    }

    fun Dialog(view: View) {

            val mDialogView= LayoutInflater.from(this).inflate(R.layout.callchedule,null)
        AlertDialog.Builder(this,R.style.mainLogin)
            val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setPositiveButton("Ok"){ dialogInterface: DialogInterface, i: Int ->
                        closeContextMenu()
                    }

        val dialog:AlertDialog =mBuilder.create()
        dialog.show()
    }
}
