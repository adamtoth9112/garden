package hu.lilacode.garden

import dagger.Component
import hu.lilacode.garden.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class))
interface MockGardenApplicationComponent: GardenApplicationComponent
