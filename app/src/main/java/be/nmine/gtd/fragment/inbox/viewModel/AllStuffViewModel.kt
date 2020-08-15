package be.nmine.gtd.fragment.inbox.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import be.nmine.gtd.StuffDTO
import be.nmine.gtd.core.application.capture.getAllStuffs.GetAllStuffHandler
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AllStuffViewModel @ViewModelInject constructor(
    private val getAllStuffHandler: GetAllStuffHandler,
    @Assisted private val savedStateHandle: SavedStateHandle): ViewModel() {

    val flow: Flow<List<StuffDTO?>> = getAllStuffHandler.handle()
        .map { value: List<Stuff?> -> value.map { stuff -> StuffDTO(stuff!!.name)  } }
}