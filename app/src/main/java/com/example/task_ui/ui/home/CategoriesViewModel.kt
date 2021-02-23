package com.example.task_ui.ui.home

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.task_ui.utils.extensions.plusAssign
import com.example.task_ui.common.App
import com.example.task_ui.data.BaseViewModel
import com.example.task_ui.data.model.home.ResultsData
import com.example.task_ui.data.repositories.CategoriesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoriesViewModel(application: Application) : BaseViewModel(application = application){


    @Inject
    lateinit var repository: CategoriesRepository

    val isLoading = ObservableField(false)

    var model = MutableLiveData<ArrayList<ResultsData>>()


    fun getOrders() {
        isLoading.set(true)
        App.instance.getComponent().injectViewModel(viewModel = this)


        compositeDisposable += repository
            .getOrders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .distinctUntilChanged()
            .subscribe({
                isLoading.set(false)


               model.value = it.resultsData
             Log.d("main","thisis"+it.toString())

            }, {
                isLoading.set(false)

                Log.d("main","thisis"+it.toString())
            })
    }

    }



