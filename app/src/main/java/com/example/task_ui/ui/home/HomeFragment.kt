package com.example.task_ui.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_ui.common.App
import com.example.task_ui.data.model.home.ResultsData
import com.example.task_ui.databinding.FragmentHomeBinding
import javax.inject.Inject


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    @Inject
    lateinit var adapter: CategoriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        instance = this

        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

        App.instance.getComponent().injectViewModel(viewModel)
        refresh()

        return binding.root
    }
    private fun refresh() {
        viewModel.apply {
            getOrders()
            model.observe(viewLifecycleOwner, {
                it?.let {
                    loadCompanies(model = it)
                }
            })
        }

    }

    private fun loadCompanies(model: ArrayList<ResultsData>) {
        App.instance.getComponent().getCategoriesListComponentBuilder.list(model = model).build()
            .injectView(view = this)


        binding.rvList.layoutManager =
            GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        binding.rvList.adapter = adapter


        adapter.notifyDataSetChanged()



    }

    companion object {

        lateinit var instance: HomeFragment

        lateinit var viewModel: CategoriesViewModel
    }
}