package news_screens

import Test.Test
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oat.R
import kotlinx.android.synthetic.main.fragment_common_news.view.*

class Common_news : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_common_news, container, false)
        view.showTest.setOnClickListener {
            val intent = Intent(context, Test::class.java)
            startActivity(intent)
        }
        return view
    }

}