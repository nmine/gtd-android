package be.nmine.gtd.application.clarify.trash

import be.nmine.gtd.application.clarify.ClarifyStuffCommand
import be.nmine.gtd.domain.basket.Stuff

class ClarifyStuffToMoveToTrash(stuff: Stuff) : ClarifyStuffCommand(stuff)