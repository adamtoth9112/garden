package hu.lilacode.garden

import dagger.Component
import hu.lilacode.garden.ui.UIModule
import hu.lilacode.garden.ui.main.MainActivity
import hu.lilacode.garden.ui.main.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class))
interface GardenApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)
}
