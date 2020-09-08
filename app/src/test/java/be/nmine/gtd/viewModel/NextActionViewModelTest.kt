package be.nmine.gtd.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NextActionViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var nextActionRepository: NextActionRepository

    @Mock
    private lateinit var observer: Observer<List<String?>>

    @Before
    fun setUp() {
        // do something if required
    }

//    @Test
//    fun viewModel_should_return_live_data_with_correct_value() {
//        val nextAction =  NextAction("test")
//        testCoroutineRule.runBlockingTest {
//            //Given
//            var flow: Flow<MutableList<NextAction?>> =
//                flowOf(
//                    mutableListOf<NextAction?>(nextAction))
//            Mockito.doReturn(flow)
//                .`when`(nextActionRepository)
//                .getAll()
//            val viewModel = NextActionViewModel(nextActionRepository, SavedStateHandle())
//            //When
//            viewModel.actionNamesLiveData.observeForever(observer)
//            //Then
//            verify(nextActionRepository).getAll()
//            verify(observer).onChanged(mutableListOf("test"))
//            viewModel.actionNamesLiveData.removeObserver(observer)
//        }
//    }

    @After
    fun tearDown() {
        // do something if required
    }

}