package com.example.student_assistant.di.injector

import com.example.student_assistant.di.scope.FragmentScope
import com.example.student_assistant.ui.filter.FilterFragment
import com.example.student_assistant.ui.main.MainFragment
import com.example.student_assistant.ui.parameter.ParameterFragment
import com.example.student_assistant.ui.project.ProjectDetailFragment
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
    abstract fun contributeParametersFragment(): ParameterFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeFiltersFragment(): FilterFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeProjectEditFragment(): ProjectEditFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeProjectDetailFragment(): ProjectDetailFragment
}