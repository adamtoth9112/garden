package hu.lilacode.garden.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.R
import hu.lilacode.garden.ui.plant.add.AddPlantFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    init {
        GardenApplication.injector?.inject(this)
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_showAddPlant -> { mainPresenter.showAddPlant(); return true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }

    override fun showAddPlant() = addOrReplaceFragment(AddPlantFragment(), "addPlant")

    private fun addOrReplaceFragment(fragment: Fragment, tag: String) {
            if (fragmentIsNew(tag))
                addFragment(fragment, tag)
            else
                replaceFragment(fragment, tag)
    }

    private fun fragmentIsNew(tag: String) = supportFragmentManager.findFragmentByTag(tag) == null

    private fun replaceFragment(fragment: Fragment, tag: String) =
        supportFragmentManager.beginTransaction().replace(this.fragment.id, fragment, tag).addToBackStack(fragment.toString()).commitAllowingStateLoss()

    private fun addFragment(fragment: Fragment, tag: String) =
        supportFragmentManager.beginTransaction().add(this.fragment.id, AddPlantFragment(), tag).addToBackStack(fragment.toString()).commitAllowingStateLoss()
}
