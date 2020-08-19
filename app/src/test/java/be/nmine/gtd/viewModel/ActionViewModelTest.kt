package be.nmine.gtd.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.presentation.fragment.actions.viewModel.ActionViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ActionViewModelTest {

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
    fun delete_action_call_on_viewModel_should_call_delete_actions_on_repository() {
        val action =  Action("test")
        testCoroutineRule.runBlockingTest {
            //Given
            val viewModel = ActionViewModel(actionRepository, SavedStateHandle())
            //When
            viewModel.deleteAction(action)
            //Then
            verify(actionRepository).remove(action)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}