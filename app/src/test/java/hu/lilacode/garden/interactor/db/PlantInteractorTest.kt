package hu.lilacode.garden.interactor.db

import hu.lilacode.garden.model.Plant
import hu.lilacode.garden.model.mock.MockDBModel
import hu.lilacode.garden.model.prod.DBModel
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers
import org.junit.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


class PlantInteractorTest {

    @get:Rule
    val mockitoRule : MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var dbModel : DBModel

    lateinit var mockDBModel : MockDBModel

    @InjectMocks
    lateinit var plantInteractor : PlantInteractor

    @Before
    fun setUp() {
        plantInteractor = PlantInteractor()
        mockDBModel = MockDBModel()
    }

    @Ignore
    @Test
    fun testGetPlants() {
        `when`(dbModel.getPlants()).thenReturn(mockDBModel.getPlants())

        val testObserver = TestObserver.create<Plant>()
        plantInteractor.getPlants()?.subscribe(testObserver)
        testObserver.assertNoErrors()
        testObserver.assertComplete()

        Assert.assertThat(testObserver.values()[0].name == "oldPlant", CoreMatchers.`is`(true))
    }
}