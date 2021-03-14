package Objects

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.oat.MainActivity
import java.util.*

class SettingsItem( var id: Int? = null, var name: String? = null, var img: Int) {
    fun openActivity(context: Context?){
        /*
        * Метод в котором выполняется суть этой настройки
        * например запуск активити
        * */
//        val intent = Intent(context, target)
//        startActivity(context, intent, null)
        Toast.makeText(context, "openActivity()", Toast.LENGTH_SHORT).show()
    }
    fun openDialog(){

    }
}