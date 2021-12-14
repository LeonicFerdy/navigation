package com.example.news_app_mvvm.UI.NewsSelected

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news_app_mvvm.Model.Article
import com.example.news_app_mvvm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_selected.*

class NewsSelectedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_selected, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if((""+att!!.urlToImage) != "") {
            Picasso.get()
                .load(""+att!!.urlToImage)
                .into(imgSelect)
        }


        author.text = ""+att!!.author
        source.text = ""+att!!.source.name
        contentText.text = ""+att!!.content
        titleTv.text = ""+att!!.title
        descTv.text = ""+att!!.description

        selengkapnyaBtn.setOnClickListener {
            val url = ""+att!!.url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        shareBtn.setOnClickListener {
            val title = ""+att!!.title
            val url = ""+att!!.url
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$title. Baca Selengkapnya : $url")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    companion object {
        @JvmStatic

        var att: Article? = null

        fun newInstance() = NewsSelectedFragment()
    }
}