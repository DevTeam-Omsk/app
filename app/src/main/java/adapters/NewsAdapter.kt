package adapters

import Objects.NewsItem
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.oat.NewsFullScreen
import com.example.oat.R
import java.util.*

class NewsAdapter(private val news: ArrayList<NewsItem>, val context: Context?): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var iv_preview: ImageView? = null
        var tvDateAdded: TextView? = null
        var tvTitle: TextView? = null
        var tvSubTitle: TextView? = null
        var btnShowMore: Button? = null


        init {
            iv_preview = itemView.findViewById(R.id.iv_preview)
            tvDateAdded = itemView.findViewById(R.id.tvDateAdded)
            tvTitle = itemView.findViewById(R.id.tvTitle)
            tvSubTitle = itemView.findViewById(R.id.tvText)
            btnShowMore = itemView.findViewById(R.id.btnShowMore)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curNewsItem: NewsItem = news[position]
        holder.iv_preview?.setImageResource(curNewsItem.preview)
        holder.tvDateAdded?.text = curNewsItem.dateAdded
        holder.tvTitle?.text = curNewsItem.title
        holder.tvSubTitle?.text = curNewsItem.sub_title
        holder.btnShowMore?.setOnClickListener {
            val intent = Intent(context!!, NewsFullScreen::class.java)
            intent.putExtra("CUR_NEWS_ITEM", curNewsItem)
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount() = news.size
}