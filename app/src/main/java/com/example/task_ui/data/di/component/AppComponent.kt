package com.example.task_ui.data.di.component

import com.example.task_ui.common.App
import com.example.task_ui.data.BaseViewModel
import com.example.task_ui.data.di.modules.ContextModules
import com.example.task_ui.ui.home.CategoriesViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModules::class])
interface AppComponent {
    val getCategoriesListComponentBuilder: CategoriesListComponent.Builder
    fun injectApp(app: App)
    fun injectViewModel(viewModel: BaseViewModel)
    fun injectViewModel(viewModel: CategoriesViewModel)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}