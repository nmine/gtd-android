package be.nmine.gtd.application.organise.createnextaction

import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.nextaction.NextAction
import be.nmine.gtd.domain.nextaction.NextActionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class CreateNextActionsHandler @Inject constructor(
    private val nextActionRepository: NextActionRepository,
    private val actionRepository: ActionRepository
) {
    suspend fun handle(command: CreateNextActionCommand) {
        val block: suspend CoroutineScope.() -> Unit = {
            val nextAction = NextAction(command.nextAction)
            async {nextActionRepository.save(nextAction)}
            async {actionRepository.remove(Action(command.actionItem))}
        }
        runBlocking(block = block)
    }

}
