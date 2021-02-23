package com.example.task_ui.data.di.component

import com.example.task_ui.data.di.scope.CategoriesScope
import com.example.task_ui.data.di.annotations.ChooserDataAnno
import com.example.task_ui.data.model.home.ResultsData
import com.example.task_ui.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Subcomponent

@CategoriesScope
@Subcomponent
interface CategoriesListComponent {
    fun injectView(view: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun list(@ChooserDataAnno model: List<ResultsData>): Builder

        fun build(): CategoriesListComponent
    }
}