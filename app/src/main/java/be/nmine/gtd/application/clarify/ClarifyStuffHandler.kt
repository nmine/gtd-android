package be.nmine.gtd.application.clarify

import be.nmine.gtd.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.application.clarify.trash.ClarifyStuffToMoveToTrash
import be.nmine.gtd.domain.action.Action
import be.nmine.gtd.domain.action.ActionRepository
import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.trash.TrashRepository

class ClarifyStuffHandler(
    val basket: Basket,
    val actionRepository: ActionRepository,
    val trashRepository: TrashRepository
) {


    fun handle(command: ClarifyStuffCommand) {
        when(command){
            is ClarifyStuffToActionCommand -> actionRepository.saveAction(
                Action(
                    command.stuff.name
                )
            )
            is ClarifyStuffToMoveToTrash -> trashRepository.addStuff(command.stuff)
        }
        basket.remove(command.stuff)
    }

}
