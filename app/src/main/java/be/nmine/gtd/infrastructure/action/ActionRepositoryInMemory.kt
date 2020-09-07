package be.nmine.gtd.infrastructure.action

import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ActionRepositoryInMemory : ActionRepository {

    val actions : MutableList<Action> = mutableListOf()

    override suspend fun saveAction(action: Action) {
       actions.add(action)
    }

    override fun getAction(name: String): Action {
        return actions.filter { action -> action.name == name }.first()
    }

    override fun getAll(): Flow<List<Action?>> {
        return flowOf(actions)
    }

    override suspend fun remove(action: Action) {
        actions.remove(action)
    }

}
