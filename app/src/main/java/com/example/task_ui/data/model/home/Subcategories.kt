package com.example.task_ui.data.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Subcategories {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("category_id")
    @Expose
    var category_id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("logo")
    @Expose
    var logo: String? = null
    @SerializedName("logo_path")
    @Expose
    var logo_path: String? = null
}