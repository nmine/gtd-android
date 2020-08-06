package be.nmine.gtd.core.application.capture

import be.nmine.gtd.core.domain.basket.Basket

class CaptureStuffHandler(basket : Basket) {

    val basket: Basket

    init{
        this.basket = basket
    }
    fun handle(command: CaptureStuffCommand) {
        basket.saveStuff(command.stuff)
    }
}
