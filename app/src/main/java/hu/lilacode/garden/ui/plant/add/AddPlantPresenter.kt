package hu.lilacode.garden.ui.plant.add

import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.interactor.db.PlantInteractor
import hu.lilacode.garden.model.Plant
import hu.lilacode.garden.ui.Presenter
import javax.inject.Inject


class AddPlantPresenter : Presenter<AddPlantScreen>() {

    @Inject
    lateinit var plantInteractor : PlantInteractor

    override fun attachScreen(screen: AddPlantScreen) {
        super.attachScreen(screen)
        GardenApplication.injector?.inject(this)
    }

    fun savePlant(newPlant : Plant) {
        plantInteractor.savePlant(newPlant)
        screen?.savePlant()
    }
}