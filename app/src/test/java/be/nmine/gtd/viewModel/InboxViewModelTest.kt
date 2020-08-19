package be.nmine.gtd.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel
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
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SingleNetworkCallViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var actionRepository: ActionRepository

    @Mock
    private lateinit var observer: Observer<List<String?>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun viewModel_should_return_live_data_with_correct_value() {
        val action =  Action("test")
        testCoroutineRule.runBlockingTest {
            //Given
            var flow: Flow<MutableList<Action?>> =
                flowOf(
                    mutableListOf<Action?>(action))
            doReturn(flow)
                .`when`(actionRepository)
                .getAll()
            val viewModel = ActionViewModel(actionRepository, SavedStateHandle())
            //When
            viewModel.actionNamesLiveData.observeForever(observer)
            //Then
            verify(actionRepository).getAll()
            verify(observer).onChanged(mutableListOf("test"))
            viewModel.actionNamesLiveData.removeObserver(observer)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}