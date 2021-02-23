package com.example.task_ui.data.repositories

import com.example.task_ui.common.App
import com.example.task_ui.data.model.home.CategoriesWrapper

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CategoriesRepository @Inject constructor()  {
    fun getOrders(): Observable<CategoriesWrapper> {
        return App.instance.api.getData.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}