package hu.lilacode.garden

import dagger.Component
import hu.lilacode.garden.interactor.InteractorModule
import hu.lilacode.garden.model.mock.MockModelModule
import hu.lilacode.garden.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, MockModelModule::class))
interface MockGardenApplicationComponent: GardenApplicationComponent
