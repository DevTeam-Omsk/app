package adapters

import Objects.Lesson
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.oat.HomeWorkForm
import com.example.oat.R
import java.io.Serializable


class LessonListAdapter(private val lessons: ArrayList<Lesson>, var context: Context?) : RecyclerView.Adapter<LessonListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cardItem: LinearLayout? = null
        var tvLessonName: TextView? = null
        var tvSubGroup: TextView? = null
        var tvTeacher: TextView? = null
        var tvRoom: TextView? = null
        var btnCardOptions: ImageButton? = null
        var isHaveHW: ImageButton? = null
        init {
            cardItem = itemView.findViewById(R.id.card_container)
            tvLessonName = itemView.findViewById(R.id.tvLessonName)
            tvSubGroup = itemView.findViewById(R.id.tvSubGroup)
            tvTeacher= itemView.findViewById(R.id.tvTeacher)
            tvRoom = itemView.findViewById(R.id.tvRoom)
            btnCardOptions = itemView.findViewById(R.id.btnCardOptions)
            isHaveHW = itemView.findViewById(R.id.isHaveHW)
        }
    }

    // возвращает общее количество элементов списка
    override fun getItemCount() = lessons.size

    // создание объекта ViewHolder
    // только тогда, когда это нужно
    // а именно тогда, когда создается layout элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.lesson_card,
                parent,
                false
        )
        return  ViewHolder(itemView)
    }


    var curLesson: Lesson? = null

    // здесь устанавливаются соответствующие значения для
    // элементов соответствующей строки
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        curLesson = lessons[position]
        holder.tvLessonName?.text = curLesson!!.name
        holder.tvSubGroup?.text = curLesson!!.group
        holder.tvRoom?.text = curLesson!!.room
        holder.tvTeacher?.text = curLesson!!.teacher
        holder.btnCardOptions?.setOnClickListener {
            // при нажатии на настройки занятия показывать меню
            // можно задать дз и напоминание
            curLesson = lessons[position]
            showPopupMenu(it, holder.tvLessonName!!.text.toString(), curLesson!!)
        }
        holder.cardItem?.setOnClickListener {
            // Создаю AlertDialog для вывода дз по нажатию на определенную пару
            curLesson = lessons[position]
            val builder = AlertDialog.Builder(context!!)
            val inflater = LayoutInflater.from(context).inflate(R.layout.lesson_alert_info, null)
            builder.setView(inflater)
            val dialog = builder.create()
            val tvLessonName =  inflater.findViewById<TextView>(R.id.tvLessonName)
            tvLessonName.text = curLesson?.name

            val tvhwText =  inflater.findViewById<TextView>(R.id.tvhwText)

            tvhwText.text = curLesson?.getHomeWorkInfo(context!!)

            val btnHwChange = inflater.findViewById<Button>(R.id.btnHwChange)
            btnHwChange.setOnClickListener {
                val intent = Intent(context, HomeWorkForm::class.java)
                intent.putExtra("CUR_NEWS_ITEM", curLesson as Serializable)
                startActivity(context!!, intent, null)
                dialog.hide()
            }
            val btnClose = inflater.findViewById<Button>(R.id.btnClose)
            btnClose.setOnClickListener {
                dialog.hide()
            }
            dialog.show()
        }
        if (curLesson!!.getHomeWorkInfo(context!!) == "Домашнего задания нет"){
            holder.isHaveHW?.visibility = View.INVISIBLE
        }
    }

    private fun showPopupMenu(view: View, name: String?, curLesson: Lesson) {
        var popupMenu = PopupMenu(context, view, Gravity.CENTER)
        popupMenu.inflate(R.menu.lesson_card_menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            val id = item.itemId
            when (id) {
                R.id.item_hw -> {
                    val intent = Intent(context, HomeWorkForm::class.java)
                    intent.putExtra("CUR_NEWS_ITEM", this.curLesson)
                    startActivity(context!!, intent, null)
                }
                R.id.item_alarm -> {
                    Toast.makeText(context, "В разработке)", Toast.LENGTH_SHORT).show()
                }
            }
            true
        })
    }
}