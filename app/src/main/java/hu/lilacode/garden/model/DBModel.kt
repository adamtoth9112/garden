package hu.lilacode.garden.model

import io.reactivex.Observable

interface DBModel {
    fun getPlants() : Observable<Plant>?
    fun savePlant(newPlant: Plant)
}