package hu.lilacode.garden.model.mock

import hu.lilacode.garden.model.DBModel
import hu.lilacode.garden.model.Plant
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class MockDBModelTest {

    lateinit var dbModel : DBModel

    @Before
    fun setUp() {
        dbModel = MockDBModel()
    }

    @Test
    fun testGetPlants() {
        val testObserver = TestObserver.create<Plant>()
        dbModel.getPlants()?.subscribe(testObserver)
        testObserver.assertNoErrors()
        testObserver.assertComplete()

        assertThat(testObserver.values()[0].name == "oldPlant", `is`(true))
    }
}