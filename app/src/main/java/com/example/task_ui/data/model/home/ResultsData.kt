package com.example.task_ui.data.model.home

import android.view.View

import com.bumptech.glide.Glide
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import androidx.databinding.BindingAdapter
import kotlinx.android.synthetic.main.items.view.*

data class ResultsData (

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("logo")
    @Expose
    var logo: String? = null,

    @SerializedName("subcategories")
    @Expose
    var subcategories: ArrayList<Subcategories>


) {
    companion object {
        @BindingAdapter("loadDonationImage")
        @JvmStatic
        fun loadImage(view: View, image: String) {
            Glide.with(view.context)
                .load(image)
                .into(view.detail_image)
        }
    }
}

