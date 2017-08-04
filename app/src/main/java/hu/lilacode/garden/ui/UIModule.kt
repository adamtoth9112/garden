package hu.lilacode.garden.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.lilacode.garden.ui.main.MainPresenter
import javax.inject.Singleton

@Module
class UIModule(val context : Context) {

    @Provides
    fun provideContext() : Context = context

    @Provides
    @Singleton
    fun provideMainPresenter() : MainPresenter =  MainPresenter()
}
