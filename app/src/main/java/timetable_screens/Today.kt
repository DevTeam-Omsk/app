package timetable_screens

import Objects.Lesson
import adapters.LessonListAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oat.R
import dbPreferences.DbHelper
import kotlinx.android.synthetic.main.fragment_today.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Today : Fragment() {
    val fgroup: String = "1 подгруппа"
    val sgroup: String = "2 подгруппа"
    val theory: String = ""
    var lessons = ArrayList<Lesson>()

    companion object{
        var curDate: String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // делаю тестовые уроки
        setRandomLessons(lessons)
    }

    @SuppressLint("SimpleDateFormat")
    private fun setInfo() {
        val sdf_weekday = SimpleDateFormat("EEEE")
        val sdf_date = SimpleDateFormat("dd.MM.yyyy")
        val d = Date()
        val dayOfTheWeek = sdf_weekday.format(d)
        curDate = sdf_date.format(d)

        tv_weekday.text = dayOfTheWeek
        tvTodayDate.text = curDate
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_today, container, false)

        val rv = view?.findViewById<RecyclerView>(R.id.rv_today)
        rv?.layoutManager = LinearLayoutManager(context)
        rv?.adapter = LessonListAdapter(lessons, context)

        val dbHelper = DbHelper(context, null, null, 1)
        val db = dbHelper.writableDatabase
        dbHelper.print_hwTable(db)
        return view
    }

    private fun setRandomLessons(lessons: ArrayList<Lesson>?) {
        lessons?.add(Lesson(1, "Русский язык", false, theory, "Преподаватель 1", "228"))
        lessons?.add(Lesson(2, "Математика", false, theory, "Преподаватель 2", "507"))
        lessons?.add(Lesson(3, "Разработка мобильных приложений", true, fgroup, "Преподаватель 3", "316"))
    }

    override fun onResume() {
        super.onResume()

        // перерисовываю список еще раз
        // это для тех случаев, когда добавляется дз,
        // чтобы иконка появилась сразу же
        val rv = view?.findViewById<RecyclerView>(R.id.rv_today)
        rv?.adapter = LessonListAdapter(lessons, context)

        // здесь я устанавливаю значения
        // для полей "Группа", "День недели" и "Дата"
        setInfo()
    }
}