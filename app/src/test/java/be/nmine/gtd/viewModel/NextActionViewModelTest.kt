package be.nmine.gtd.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import be.nmine.gtd.presentation.fragment.nextactions.viewModel.NextActionViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
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

    @Test
    fun viewModel_should_return_live_data_with_correct_value() {
        val nextAction =  NextAction("test")
        testCoroutineRule.runBlockingTest {
            //Given
            var flow: Flow<MutableList<NextAction?>> =
                flowOf(
                    mutableListOf<NextAction?>(nextAction))
            Mockito.doReturn(flow)
                .`when`(nextActionRepository)
                .getAll()
            val viewModel = NextActionViewModel(nextActionRepository, SavedStateHandle())
            //When
            viewModel.nextActionNamesLiveData.observeForever(observer)
            //Then
            verify(nextActionRepository).getAll()
            verify(observer).onChanged(mutableListOf("test"))
            viewModel.nextActionNamesLiveData.removeObserver(observer)
        }
    }

    @Test
    fun viewModel_should_be_able_to_create_next_action_from_action_item() {
        val nextAction =  NextAction("test")
        testCoroutineRule.runBlockingTest {
            //Given
            var flow: Flow<MutableList<NextAction?>> =
                flowOf(
                    mutableListOf<NextAction?>(nextAction))
            Mockito.doReturn(flow)
                .`when`(nextActionRepository)
                .getAll()
            val viewModel = NextActionViewModel(nextActionRepository, SavedStateHandle())
            //When
            viewModel.nextActionNamesLiveData.observeForever(observer)
            //Then
            verify(nextActionRepository).getAll()
            verify(observer).onChanged(mutableListOf("test"))
            viewModel.nextActionNamesLiveData.removeObserver(observer)
        }
    }

    @Test
    fun viewModel_should_be_able_to_delete_action_item() {
        val nextAction =  NextAction("test")
        testCoroutineRule.runBlockingTest {
            //Given
            val viewModel = NextActionViewModel(nextActionRepository, SavedStateHandle())
            //When
            viewModel.deleteNextAction(nextAction)
            //Then
            verify(nextActionRepository).remove(nextAction)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}