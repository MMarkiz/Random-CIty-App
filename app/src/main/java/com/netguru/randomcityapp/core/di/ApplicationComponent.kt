package com.netguru.randomcityapp.core.di

import com.netguru.data.di.DatabaseModule
import com.netguru.data.di.RepositoriesModule
import com.netguru.randomcityapp.MyApplication
import com.netguru.randomcityapp.presentation.main.di.MainActivityInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //app
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        MainActivityInjector::class,
        CoroutinesModule::class,
        //data
        DatabaseModule::class,
        RepositoriesModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): ApplicationComponent
    }
}