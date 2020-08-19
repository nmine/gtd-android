package be.nmine.gtd.presentation.fragment.inbox.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.nmine.gtd.application.capture.captureStuff.CaptureStuffCommand
import be.nmine.gtd.application.capture.captureStuff.CaptureStuffHandler
import be.nmine.gtd.application.capture.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.application.clarify.ClarifyStuffHandler
import be.nmine.gtd.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.presentation.fragment.inbox.StuffDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class InboxViewModel @ViewModelInject constructor(
    private val getAllStuffHandler: GetAllStuffHandler,
    private val captureStuffHandler: CaptureStuffHandler,
    private val clarifyStuffHandler: ClarifyStuffHandler,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {


    val flow: Flow<List<StuffDTO?>> = getAllStuffHandler.handle()
        .map { value: List<Stuff?> -> value.map { stuff ->
            StuffDTO(
                stuff!!.name
            )
        } }

    fun captureStuff(stuff: Stuff) = viewModelScope.launch {
        captureStuffHandler.handle(CaptureStuffCommand(stuff))
    }

    fun clarifyStuffToAction(stuff: Stuff) = viewModelScope.launch {
        clarifyStuffHandler.handle(ClarifyStuffToActionCommand(stuff))
    }
}