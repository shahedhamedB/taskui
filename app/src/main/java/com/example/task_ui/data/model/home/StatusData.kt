package com.example.task_ui.data.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StatusData {
    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("code")
    @Expose
    var code: Int? = null
}