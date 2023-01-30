package com.example.student_assistant.di.injector

import com.example.student_assistant.di.scope.ActivityScope
import com.example.student_assistant.SampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModuleInjector {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): SampleActivity
}