package com.example.task_ui.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_ui.R
import com.example.task_ui.data.di.scope.CategoriesScope
import com.example.task_ui.data.di.annotations.ChooserDataAnno
import com.example.task_ui.data.model.home.ResultsData
import com.example.task_ui.databinding.ItemsBinding
import javax.inject.Inject

@CategoriesScope
class CategoriesAdapter @Inject constructor(@ChooserDataAnno private val modelList: List<ResultsData>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemsBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelList[position])


    }



    override fun getItemCount(): Int = modelList.size

    inner class ViewHolder(private var binding: ItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(model: ResultsData) {
            binding.let {
                it.model = model; it.viewModel = HomeFragment.viewModel
            }
            binding.executePendingBindings()
            binding.cardView.setOnClickListener {
               var  isselected = true;

                if (isselected) {
                    binding.cardView.setCardBackgroundColor(R.color.purple_700)
                    binding.textView.setTextColor(Color.WHITE)

                } else {
                    binding.cardView.setCardBackgroundColor(Color.WHITE)
                }


            }
        }
    }
}