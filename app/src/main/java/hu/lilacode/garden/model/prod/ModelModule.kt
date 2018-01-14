package hu.lilacode.garden.model.prod

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {

    @Provides
    @Singleton
    fun provideDBModel() : hu.lilacode.garden.model.DBModel = DBModel()
}