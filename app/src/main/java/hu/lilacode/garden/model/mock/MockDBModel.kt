package hu.lilacode.garden.model.mock

import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.model.DBModel
import hu.lilacode.garden.model.Plant
import io.reactivex.Observable

class MockDBModel : DBModel {

    private var plants: MutableList<Plant> = ArrayList()

    init {
        GardenApplication.injector?.inject(this)
        plants.add(Plant("oldPlant"))
    }

    override fun getPlants() = Observable.fromIterable(plants)

    override fun savePlant(newPlant: Plant) {
        plants.add(newPlant)
    }
}