package hu.lilacode.garden.ui.plant.add

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.R
import hu.lilacode.garden.model.Plant
import kotlinx.android.synthetic.main.fragment_addplant.*
import javax.inject.Inject


class AddPlantFragment : Fragment(), AddPlantScreen {

    init {
        GardenApplication.injector?.inject(this)
    }

    @Inject
    lateinit var addPlantPresenter : AddPlantPresenter

    private var savePlant : AppCompatButton? = null
    private var  plantName: TextInputLayout? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater?.inflate(R.layout.fragment_addplant, container, false)

        plantName = fragmentView?.findViewById(R.id.plant_name_layout) as TextInputLayout
        savePlant = fragmentView.findViewById(R.id.save_plant) as AppCompatButton
        savePlant?.setOnClickListener { e ->
                addPlantPresenter.savePlant(Plant(plantName?.editText?.text.toString()))
        }

        return fragmentView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        addPlantPresenter.attachScreen(this)
    }

    override fun onDetach() {
        addPlantPresenter.detachScreen()
        super.onDetach()
    }

    override fun savePlant() {
        savePlant?.text = plantName?.editText?.text.toString()
    }
}