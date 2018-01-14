package hu.lilacode.garden.model.prod

import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.model.DBModel
import hu.lilacode.garden.model.Plant
import io.reactivex.Observable


class DBModel : DBModel {

    init {
        GardenApplication.injector?.inject(this)
    }

    override fun getPlants() : Observable<Plant> = Observable.fromIterable(ArrayList<Plant>())

    override fun savePlant(newPlant: Plant) {}
}