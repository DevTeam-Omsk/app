package dbPreferences;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private String LOG_TAG = "SQLiteOpenHelper Logs";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "main_db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "\n--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table hworks ("
                + "id integer primary key autoincrement,"
                + "lesson_id int,"
                + "actions text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void print_hwTable(SQLiteDatabase db) {
        /*
            Метод выводит таблицу с домашним заданием по всем парам
         */
        Log.d(LOG_TAG, "\n--- Rows in hworks: ---");

        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c  = db.query("hworks", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {
            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int lesson_idColIndex = c.getColumnIndex("lesson_id");
            int actionsColIndex = c.getColumnIndex("actions");
            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "\nID = " + c.getInt(idColIndex) +
                                ",\nlesson_id = " + c.getString(lesson_idColIndex).toString() +
                                ",\nactions = " + c.getString(actionsColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else Log.d(LOG_TAG, "\n\n\n0 rows");
        c.close();
    }

    public void delete_hwTable(SQLiteDatabase db){
        /*
            Метод удаляет таблицу с дз
        */
        Log.d(LOG_TAG, "\n--- Clear mytable: ---");
        // удаляем все записи
        int clearCount = db.delete("hworks", null, null);
        Log.d(LOG_TAG, "deleted rows count = " + clearCount);
    }

    public void delete_database(Context context, String db){
        /*
            Метод удаляет базу данных main_db
         */
        context.deleteDatabase(db);
    }
}
