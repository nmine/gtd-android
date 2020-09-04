package be.nmine.gtd.application.clarify.action

import be.nmine.gtd.application.clarify.ClarifyStuffCommand
import be.nmine.gtd.domain.basket.Stuff

class ClarifyStuffToActionCommand(stuff: Stuff) : ClarifyStuffCommand(stuff)
