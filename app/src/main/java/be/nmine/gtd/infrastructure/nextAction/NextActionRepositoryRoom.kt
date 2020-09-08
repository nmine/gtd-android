package be.nmine.gtd.infrastructure.nextAction

import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NextActionRepositoryRoom @Inject constructor(private val nextActionRoomDao: NextActionRoomDao) :
    NextActionRepository {

    override fun getAll(): Flow<List<NextAction?>> {
        return nextActionRoomDao.getAll().map { it ->
            it.map { actionRoom ->
                actionRoom.name?.let { NextAction(it) }
            }
        }
    }

    override fun getNextAction(name: String): NextAction {
        TODO("Not yet implemented")
    }

    override suspend fun save(nextAction: NextAction) {
        TODO("Not yet implemented")
    }

}
