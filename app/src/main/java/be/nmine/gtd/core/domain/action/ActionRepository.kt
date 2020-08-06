package be.nmine.gtd.core.domain.action

import be.nmine.gtd.core.domain.action.Action

interface ActionRepository {

    fun saveAction(action : Action)
    fun getAction(name: String): Action


}