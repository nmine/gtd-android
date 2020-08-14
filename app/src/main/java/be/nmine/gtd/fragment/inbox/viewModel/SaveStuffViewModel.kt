package be.nmine.gtd.fragment.inbox.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import kotlinx.coroutines.launch

class SaveStuffViewModel @ViewModelInject constructor(
    private val basket: Basket,
    @Assisted private val savedStateHandle: SavedStateHandle): ViewModel() {

    fun saveStuff(stuff: Stuff) = viewModelScope.launch {
        basket.saveStuff(stuff)
    }
}