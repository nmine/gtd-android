package be.nmine.gtd.infrastructure.action

import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ActionRepositoryRoom @Inject constructor(private val actionRoomDao: ActionRoomDao) : ActionRepository {

    override suspend fun saveAction(action: Action) {
        actionRoomDao.save(ActionRoom(name = action.name))
    }

    override fun getAction(name: String): Action {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<Action?>> {
        return actionRoomDao.getAll().map { actionRooms: List<ActionRoom> ->
            actionRooms.map { actionRoom ->
                actionRoom.name?.let { Action(it) }
            }
        }
    }

    override suspend fun remove(action: Action) {
        actionRoomDao.delete(action.name)
    }


}
