package com.example.student_assistant.di.injector

import com.example.student_assistant.di.scope.FragmentScope
import com.example.student_assistant.ui.filter.FiltersFragment
import com.example.student_assistant.ui.main.MainFragment
import com.example.student_assistant.ui.parameter.ParametersFragment
import com.example.student_assistant.ui.project.ProjectEditFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModuleInjector {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeParametersFragment(): ParametersFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeFiltersFragment(): FiltersFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeProjectEditFragment(): ProjectEditFragment
}