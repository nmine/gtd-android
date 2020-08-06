package be.nmine.gtd.core.application

import be.nmine.gtd.core.domain.Basket

class CaptureStuffHandler(basket : Basket) {

    val basket: Basket

    init{
        this.basket = basket
    }
    fun handle(command: CaptureStuffCommand) {
        basket.saveStuff(command.stuff)
    }
}
