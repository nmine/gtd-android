package be.nmine.gtd.presentation.fragment.nextactions.viewModel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.flow.map

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
}
