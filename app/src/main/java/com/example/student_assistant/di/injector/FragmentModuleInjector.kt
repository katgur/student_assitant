package com.example.student_assistant.di.injector

import com.example.student_assistant.di.scope.FragmentScope
import com.example.student_assistant.ui.fragment.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModuleInjector {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}