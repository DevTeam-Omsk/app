package com.example.oat

import Objects.Lesson
import android.content.ContentValues
import android.database.Cursor
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import dbPreferences.DbHelper
import kotlinx.android.synthetic.main.activity_home_work_form.*
import timetable_screens.Today.Companion.curDate

class HomeWorkForm : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work_form)

        val curLesson = intent.getSerializableExtra("CUR_NEWS_ITEM") as Lesson
        tvLessonName.setText(curLesson.name)
        tvLessonDate.setText(curDate)

        btnSaveHW.setOnClickListener {
            // Сохраняю дз
            if(!editText.text.toString().equals("")) {
                dbSetSettings(curLesson)
                finish()
            }else{
                Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            }
        }

        btnClose.setOnClickListener {
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun dbSetSettings(curLesson: Lesson) {
        val dbHelper = DbHelper(this, null, null, 1)
        val db = dbHelper.writableDatabase
        val cv = ContentValues()
        cv.put("lesson_id", curLesson.id)
        cv.put("actions", editText.text.toString())

        // проверяю, есть ли уже дз
        if (curLesson.getHomeWorkInfo(this) == "Домашнего задания нет"){
            // если дз еще не заполнено, то добавляем запись в бд
            cv.put("lesson_id", curLesson.id)
            cv.put("actions", editText.text.toString())
            db.insert("hworks", null, cv)
        }else{
            // если дз уже было задано, то перезаписываем его
            db.update("hworks", cv, "lesson_id = ${curLesson.id.toString()}", null)
        }

        dbHelper.print_hwTable(db)
    }

}