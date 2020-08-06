package be.nmine.gtd.core.domain

interface ActionRepository {

    fun saveAction(action : Action)
    fun getAction(name: String): Action


}