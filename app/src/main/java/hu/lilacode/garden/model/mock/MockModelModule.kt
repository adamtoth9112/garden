package hu.lilacode.garden.model.mock

import dagger.Module
import dagger.Provides
import hu.lilacode.garden.model.DBModel
import javax.inject.Singleton

@Module
class MockModelModule {

    @Provides
    @Singleton
    fun provideMockDBModel() : DBModel = MockDBModel()
}