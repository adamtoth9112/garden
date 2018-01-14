package hu.lilacode.garden.ui.main

import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.ui.Presenter

class MainPresenter : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        GardenApplication.injector?.inject(this)
    }

    fun showAddPlant() {
        screen?.showAddPlant()
    }
}
