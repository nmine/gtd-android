package be.nmine.gtd.infrastructure.nextAction

import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class NextActionRepositoryInMemory : NextActionRepository {
    private var nextActions: MutableList<NextAction> = mutableListOf()

    override fun getNextAction(name: String): NextAction {
        return nextActions.filter { nextAction ->  nextAction.name == name }.first()
    }

    override suspend fun save(nextAction: NextAction) {
        nextActions.add(nextAction)
    }

    override suspend fun remove(nextAction: NextAction) {
        nextActions.remove(nextAction)
    }

    override fun getAll(): Flow<List<NextAction?>> {
        return flowOf(nextActions)
    }

}