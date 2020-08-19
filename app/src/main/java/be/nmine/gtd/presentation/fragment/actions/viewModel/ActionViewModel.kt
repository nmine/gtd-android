package be.nmine.gtd.presentation.fragment.actions.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ActionViewModel @ViewModelInject constructor(
    private val actionRepository: ActionRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {


    val actionNamesLiveData: LiveData<List<String>> = actionRepository.getAll()
        .map { value: List<Action?> -> value.map { action ->
                action!!.name
        }}.asLiveData()

    fun saveAction(action: Action) = viewModelScope.launch {
        actionRepository.saveAction(action)
    }
}