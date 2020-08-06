package be.nmine.gtd.core.application

import be.nmine.gtd.core.domain.Action
import be.nmine.gtd.core.domain.ActionRepository
import be.nmine.gtd.core.domain.TrashRepository

class ClarifyStuffHandler(
    val actionRepository: ActionRepository,
    val trashRepository: TrashRepository
) {


    fun handle(command: ClarifyStuffCommand) {
        when(command){
            is ClarifyStuffToActionCommand -> actionRepository.saveAction(Action(command.stuff.name))
            is ClarifyStuffToMoveToTrash -> trashRepository.addStuff(command.stuff)
        }
    }

}
