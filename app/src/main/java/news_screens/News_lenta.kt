package news_screens

import Objects.NewsItem
import adapters.NewsAdapter
import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oat.R
import kotlinx.android.synthetic.main.fragment_news_lenta.*
import java.util.*
import kotlin.collections.ArrayList

class News_lenta : Fragment() {

    var news = ArrayList<NewsItem>()

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSomeNews(news)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_news_lenta, container, false)
        val rv_lenta = view?.findViewById<RecyclerView>(R.id.rv_lenta)
        rv_lenta?.layoutManager = LinearLayoutManager(context)

        rv_lenta?.adapter = NewsAdapter(news, context)
        return view
    }


    private fun setSomeNews(news: java.util.ArrayList<NewsItem>) {
        news.add(NewsItem(R.drawable.test_img, "В Омской области реорганизуют профессиональные образовательные организации",
                "На заседании правительства Омской области принято решение о присоединении техникума высоких технологий машиностроения к Омскому авиационному колледжу имени Жуковского...",
                "На заседании правительства Омской области принято решение о присоединении техникума высоких технологий машиностроения к Омскому авиационному колледжу имени Жуковского и регионального многопрофильного колледжа к торгово-экономическому колледжу имени Г.Д. Зуйковой.\n",
                "Автор",
                "13.02.2021"
        ))
        news.add(NewsItem(R.drawable.test_img2, "Вот и прошли первенство России по гиревому спорту среди юношей и девушек!",
                "Наша федерация достойна провела соревнования!\n",
                "Наша федерация достойна провела соревнования!\n" +
                        "В общем омандном зачете Омская область заняла 1 место среди старших юношей и 3 место среди младших юношей и девушек!\n" +
                        "#первенствороссии",
                "Автор",
                "13.02.2021"
        ))
        news.add(NewsItem(R.drawable.test_img3, "В Омский аэропорт требуются выпускники Омавиат",
                "Требуются выпускники Омавиат на вакансию Оператор по наземному обслуживанию воздушных судов.",
                "Оплата от 25 000 руб.\n" +
                        "89045880293 (Дмитрий Владимирович).\n" +
                        "Желательно Техническое обслуживание авиационных двигателей или производство летательных аппаратов",
                "Автор",
                "13.02.2021"
        ))
        news.add(NewsItem(R.drawable.test_img4, "ВНИМАНИЕ! ТРЕБУЕТСЯ!",
                "Инженер по ремонту электронного оборудования. Линейный инженер по ремонту электронного оборудования (с выездами на объекты клиентов)...",
                "Инженер по ремонту электронного оборудования;\n" +
                        "➤ Линейный инженер по ремонту электронного оборудования (с выездами на объекты клиентов). Обязанности:\n" +
                        "• диагностика и устранение неисправностей обслуживаемой техники и программного обеспечения;\n" +
                        "• информационно-консультационная поддержка Клиентов компании по вопросам эксплуатации оборудования;\n" +
                        "• установка, настройка и обслуживание онлайн-касс, POS-систем, компьютерной техники и POS-периферии. Мы Вам предлагаем:\n" +
                        "• офис компании находится в центре города с удобной транспортной доступностью и инфраструктурой;\n" +
                        "• трудоустройство по ТК РФ;\n" +
                        "• постоянное обучение и повышение квалификации, профессиональный рост;\n" +
                        "• работа в дружном, креативном, энергичном коллективе; • наставничество.\n" +
                        "\n" +
                        "Если Вы\n" +
                        "стремитесь к развитию, личностному и профессиональному росту,\n" +
                        "то Вам к нам!\n" +
                        "\n" +
                        "Наш адрес: г. Омск, ул. Пушкина, 32 (первый этаж).\n" +
                        "Информация по телефону: 8-965-986-09-64\n" +
                        "#работаомск#омск55#студент2020#колледжомск#кудапойтиучиться",
                "Автор",
                "13.02.2021"
        ))
    }
}