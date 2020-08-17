package be.nmine.gtd.presentation.fragment.actions.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.presentation.fragment.actions.ActionDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ActionViewModel @ViewModelInject constructor(
    private val actionRepository: ActionRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {


    val flow: Flow<List<ActionDTO?>> = actionRepository.getAll()
        .map { value: List<Action?> -> value.map { action ->
            ActionDTO(
                action!!.name
            )
        } }

    fun saveAction(action: Action) = viewModelScope.launch {
        actionRepository.saveAction(action)
    }
}