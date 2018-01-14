package hu.lilacode.garden.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.lilacode.garden.ui.main.MainPresenter
import hu.lilacode.garden.ui.plant.add.AddPlantPresenter
import javax.inject.Singleton

@Module
class UIModule(private val context : Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter() =  MainPresenter()

    @Provides
    @Singleton
    fun provideAddPlantPresenter() = AddPlantPresenter()
}
