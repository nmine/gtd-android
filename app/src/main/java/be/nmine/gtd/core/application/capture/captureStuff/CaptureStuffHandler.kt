package be.nmine.gtd.core.application.capture.captureStuff

import be.nmine.gtd.core.domain.basket.Basket
import javax.inject.Inject

class CaptureStuffHandler @Inject constructor(basket : Basket) {

    val basket: Basket

    init{
        this.basket = basket
    }
    fun handle(command: CaptureStuffCommand) {
        basket.saveStuff(command.stuff)
    }
}
