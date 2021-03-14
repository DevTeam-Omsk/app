package Objects

import android.content.Context
import android.database.Cursor
import dbPreferences.DbHelper
import java.io.Serializable

class Lesson(id: Int, name: String, type: Boolean, group: String , teacher: String, room: String): Serializable {
    var id: Int? = id
    var name: String? = name

    // тип пары: Теория или практика
    // false - теория
    // true - практика
    var type: Boolean? = type

    // !!!!!!НУЖНО ДОРАБОТАТЬ!!!!!!!
    // пока не придумал, как выводить группы подгруппы
    // что делать когда пара практики?
    // как выводить преподов и кабинеты в таком случае?
    // а что если разные пары у двух подгрупп?

    var group: String? = group
    var teacher: String? = "Преподаватель: $teacher"

    var room: String? = "Кабинет: $room"

    var hwork: String = "Домашнего задания нет"

    fun printInfo(): String{
        /*
            Метод выводит информацию об уроке
         */
        return "ID: $this.id | NAME: ${this.name} | TYPE: ${this.type} | GROUP: ${this.group} | TEACHER: ${this.teacher} | ROOM: $this.room"
    }

    fun getHomeWorkInfo(context: Context): String{
        /*
            Метод выводит домашнее задание на урок
         */
        val dbHelper = DbHelper(context, null, null, 1)
        val db = dbHelper.writableDatabase

        val cur: Cursor = db.rawQuery("SELECT actions FROM hworks WHERE lesson_id = $id", arrayOf())
        while (cur.moveToNext()) {
            hwork = cur.getString(cur.getColumnIndex("actions"))
        }
        return hwork
    }
}