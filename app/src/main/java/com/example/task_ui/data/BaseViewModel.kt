package com.example.task_ui.data

import android.app.Application

import androidx.lifecycle.AndroidViewModel

import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
