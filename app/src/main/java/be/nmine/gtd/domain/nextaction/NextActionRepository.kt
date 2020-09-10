package be.nmine.gtd.domain.nextaction

import kotlinx.coroutines.flow.Flow

interface NextActionRepository {
    fun getAll(): Flow<List<NextAction?>>
    fun getNextAction(name: String): NextAction
    suspend fun save(nextAction: NextAction)
    suspend fun remove(nextAction: NextAction)
}
