package be.nmine.gtd.core.application.clarify

import be.nmine.gtd.core.application.clarify.action.ClarifyStuffToActionCommand
import be.nmine.gtd.core.application.clarify.trash.ClarifyStuffToMoveToTrash
import be.nmine.gtd.core.domain.action.Action
import be.nmine.gtd.core.domain.action.ActionRepository
import be.nmine.gtd.core.domain.trash.TrashRepository

class ClarifyStuffHandler(
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
    }

}
