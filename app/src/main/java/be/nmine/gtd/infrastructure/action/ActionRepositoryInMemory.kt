package be.nmine.gtd.infrastructure.action

import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository

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
