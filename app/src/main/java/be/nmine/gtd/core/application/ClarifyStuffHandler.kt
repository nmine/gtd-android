package be.nmine.gtd.core.application

import be.nmine.gtd.core.domain.Action
import be.nmine.gtd.core.domain.ActionRepository

class ClarifyStuffHandler(val actionRepository: ActionRepository) {


    fun handle(command: ClarifyStuffToActionCommand) {
        actionRepository.saveAction(Action(command.stuff))
    }

}
