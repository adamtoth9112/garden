package hu.lilacode.garden.interactor.db

import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.model.Plant
import hu.lilacode.garden.model.DBModel
import javax.inject.Inject


class PlantInteractor {

    @Inject
    lateinit var dbModel : DBModel

    init {
        GardenApplication.injector?.inject(this)
    }

    fun getPlants() = dbModel.getPlants()

    fun savePlant(newPlant: Plant) = dbModel.savePlant(newPlant)
}