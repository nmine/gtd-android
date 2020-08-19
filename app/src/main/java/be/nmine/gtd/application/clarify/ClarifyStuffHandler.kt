package be.nmine.gtd.application.clarify

import be.nmine.gtd.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ClarifyStuffHandler @Inject constructor(
    private val basket: Basket,
    private val actionRepository: ActionRepository
//    private val trashRepository: TrashRepository
) {
    suspend fun handle(command: ClarifyStuffCommand) {
        when (command) {
            is ClarifyStuffToActionCommand -> {
                runBlocking {
                    actionRepository.saveAction(Action(command.stuff.name))
                    basket.remove(command.stuff)
                }
            }
//            is ClarifyStuffToMoveToTrash -> trashRepository.addStuff(command.stuff)
        }
        basket.remove(command.stuff)
    }

}
