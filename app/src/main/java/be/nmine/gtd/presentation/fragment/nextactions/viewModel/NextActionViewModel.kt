package be.nmine.gtd.presentation.fragment.nextactions.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NextActionViewModel @ViewModelInject constructor(
    private val  nextActionRepository: NextActionRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {
    val nextActionNamesLiveData: LiveData<List<String>> = nextActionRepository.getAll()
        .map { value: List<NextAction?> ->
            value.map {
                it!!.name
            }
        }
        .asLiveData()

    fun deleteNextAction(nextAction: NextAction) = viewModelScope.launch {
        nextActionRepository.remove(nextAction)
    }
}
