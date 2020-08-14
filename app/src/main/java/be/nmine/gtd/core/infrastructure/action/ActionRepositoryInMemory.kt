package be.nmine.gtd.core.infrastructure.action

import be.nmine.gtd.core.domain.action.Action
import be.nmine.gtd.core.domain.action.ActionRepository

class ActionRepositoryInMemory :
    ActionRepository {

    val actions : MutableList<Action> = mutableListOf()

    override fun saveAction(action: Action) {
       actions.add(action)
    }

    override fun getAction(name: String): Action {
        return actions.filter { action -> action.name == name }.first()
    }

}
