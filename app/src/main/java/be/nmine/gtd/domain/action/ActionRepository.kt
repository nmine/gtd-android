package be.nmine.gtd.domain.action

import kotlinx.coroutines.flow.Flow

interface ActionRepository {

    suspend fun saveAction(action : Action)
    fun getAction(name: String): Action
    fun getAll(): Flow<List<Action?>>

}