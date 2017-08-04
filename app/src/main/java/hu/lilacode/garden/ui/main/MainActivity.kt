package hu.lilacode.garden.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.lilacode.garden.GardenApplication
import hu.lilacode.garden.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "hello"

        GardenApplication.injector?.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }
}
