package com.example.task_ui.utils.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * this extension use += instead of add in compositeDisposable
 *
 */

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}