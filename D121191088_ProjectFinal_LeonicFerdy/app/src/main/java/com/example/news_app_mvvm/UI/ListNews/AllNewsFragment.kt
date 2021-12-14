package com.example.news_app_mvvm.UI.ListNews

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app_mvvm.Adapter.NewsAdapter
import com.example.news_app_mvvm.Model.Article
import com.example.news_app_mvvm.R
import com.example.news_app_mvvm.UI.NewsSelected.NewsSelectedFragment

class AllNewsFragment : Fragment() {

    companion object {
        fun newInstance() = AllNewsFragment()
    }

    private lateinit var viewModel : NewsViewModel
    private lateinit var viewModelFactory: NewsViewModelFactory
    private lateinit var rcView : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var progresBar : ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelFactory = NewsViewModelFactory(NewsRepository())
        viewModel = ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)

        return inflater.inflate(R.layout.allnews_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("AllNewsFragment", "create view")


        rcView = view.findViewById(R.id.recyViewAllNews)
        progresBar = view.findViewById(R.id.progressBar)
        linearLayoutManager = LinearLayoutManager(context)
        rcView.layoutManager = linearLayoutManager

        viewModel.getAllNewsFromRepo().observe(viewLifecycleOwner, Observer<ArrayList<Article>> {

            val adapter = NewsAdapter(it, object : NewsAdapter.OnItemClickListener {
                override fun onItemClick(att: Article) {
                    pindahKeNewsSelectedFragment(att)
                }
            })

            rcView.adapter = adapter
            progresBar.visibility = View.GONE
        })
    }

    fun pindahKeNewsSelectedFragment(att: Article) {
        NewsSelectedFragment.att = att
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.containerFrame, NewsSelectedFragment.newInstance())
            ?.addToBackStack(null)
            ?.commit()

    }

}