package hu.lilacode.garden.interactor

import dagger.Module
import dagger.Provides
import hu.lilacode.garden.interactor.db.PlantInteractor


@Module
open class InteractorModule {

    @Provides
    fun providePlantDBInteractor() = PlantInteractor()
}