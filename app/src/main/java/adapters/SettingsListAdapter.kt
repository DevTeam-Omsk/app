package adapters

import Objects.SettingsItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oat.MainActivity
import com.example.oat.R

class SettingsListAdapter(private val items: ArrayList<SettingsItem>, var context: Context?): RecyclerView.Adapter<SettingsListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var wrapper: LinearLayout? = null
        var item_icon: ImageView? = null
        var tvItemName: TextView? = null
        init {
            wrapper = itemView.findViewById(R.id.wrapper)
            item_icon = itemView.findViewById(R.id.item_icon)
            tvItemName = itemView.findViewById(R.id.tvItemName)
        }
    }

    // возвращает общее количество элементов списка
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SettingsListAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.settings_item,
            parent,
            false
        )
        return SettingsListAdapter.ViewHolder(itemView)
    }

    var curSettingsItem: SettingsItem? = null
    override fun onBindViewHolder(holder: SettingsListAdapter.ViewHolder, position: Int) {
        curSettingsItem = items[position]
        holder.item_icon?.setImageResource(curSettingsItem!!.img)
        holder.tvItemName?.text = curSettingsItem?.name
        holder.wrapper?.setOnClickListener{
            curSettingsItem?.openActivity(context)
        }
    }


}