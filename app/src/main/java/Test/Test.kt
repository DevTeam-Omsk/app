package Test

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.oat.R
import dbPreferences.DbHelper


class Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val dbHelper = DbHelper(this, null, null, 1)
        val database = dbHelper.writableDatabase
        dbHelper.print_hwTable(database)
        dbHelper.delete_hwTable(database)
        dbHelper.delete_database(this, "main_db");
    }
}