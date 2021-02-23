package com.example.task_ui.data.di.annotations

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ChooserDataAnno(val value: String = "categoriesListModel")
