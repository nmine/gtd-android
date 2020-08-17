package be.nmine.gtd.domain.action

interface ActionRepository {

    fun saveAction(action : Action)
    fun getAction(name: String): Action


}