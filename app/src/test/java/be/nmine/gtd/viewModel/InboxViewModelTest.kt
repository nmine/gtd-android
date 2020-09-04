package be.nmine.gtd.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import be.nmine.gtd.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.application.capture.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.application.clarify.ClarifyStuffHandler
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.domain.trash.TrashRepository
import be.nmine.gtd.presentation.fragment.inbox.viewModel.InboxViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class InboxViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var basket: Basket

    @Mock
    private lateinit var trashRepository: TrashRepository

    @Mock
    private lateinit var actionRepository: ActionRepository

    @InjectMocks
    private lateinit var getAllStuffHandler: GetAllStuffHandler

    @InjectMocks
    private lateinit var captureStuffHandler: CaptureStuffHandler

    @InjectMocks
    private lateinit var clarifyStuffHandler: ClarifyStuffHandler

    @Before
    fun setUp() {
        // do something if required
    }


    @Test
    fun can_get_inboxZero() {
        val stuff =  Stuff("test")
        val suspendFunction1: suspend TestCoroutineScope.() -> Unit = {
            val viewModel = getInboxViewModel()
            //When
            viewModel.inboxZero
            //Then
            verify(basket).getTimeSinceLastInboxZero()
        }
    }

    @Test
    fun viewModel_should_return_live_data_with_correct_value() {
        val stuff =  Stuff("test")
        testCoroutineRule.runBlockingTest {
            val viewModel = getInboxViewModel()
            //When
            viewModel.clarifyStuffToTrash(stuff)
            //Then
            verify(trashRepository).addStuff(stuff)
        }
    }

    private fun getInboxViewModel(): InboxViewModel {
        return InboxViewModel(
            getAllStuffHandler,
            captureStuffHandler,
            clarifyStuffHandler,
            basket,
            SavedStateHandle())
    }

    @After
    fun tearDown() {
        // do something if required
    }

}