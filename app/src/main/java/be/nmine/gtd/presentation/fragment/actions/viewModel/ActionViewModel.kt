package be.nmine.gtd.presentation.fragment.actions.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import be.nmine.gtd.application.organise.createnextaction.CreateNextActionCommand
import be.nmine.gtd.application.organise.createnextaction.CreateNextActionsHandler
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ActionViewModel @ViewModelInject constructor(
    private val actionRepository: ActionRepository,
    private val createNextActionsHandler: CreateNextActionsHandler,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    val actionNamesLiveData: LiveData<List<String>> = actionRepository.getAll()
        .map { value: List<Action?> ->
            value.map { action ->
                action!!.name
            }
        }.asLiveData()

    fun deleteAction(action: Action) = viewModelScope.launch {
        actionRepository.remove(action)
    }

    fun moveToNextAction(action: Action) = viewModelScope.launch {
        createNextActionsHandler.handle(CreateNextActionCommand(action.name))
    }
}