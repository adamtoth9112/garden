package hu.lilacode.garden

import dagger.Component
import hu.lilacode.garden.interactor.InteractorModule
import hu.lilacode.garden.interactor.db.PlantInteractor
import hu.lilacode.garden.model.DBModel
import hu.lilacode.garden.model.prod.ModelModule
import hu.lilacode.garden.ui.UIModule
import hu.lilacode.garden.ui.main.MainActivity
import hu.lilacode.garden.ui.main.MainPresenter
import hu.lilacode.garden.ui.plant.add.AddPlantFragment
import hu.lilacode.garden.ui.plant.add.AddPlantPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(UIModule::class, InteractorModule::class, ModelModule::class))
interface GardenApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)

    fun inject(addPlantFragment: AddPlantFragment)

    fun inject(addPlantPresenter: AddPlantPresenter)

    fun inject(plantInteractor: PlantInteractor)

    fun inject(dbModel: DBModel)
}
