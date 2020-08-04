package be.nmine.gtd.core.application

import be.nmine.gtd.core.domain.Basket
import be.nmine.gtd.core.infrastructure.BasketInMemory

class CaptureStuffHandler(basket : Basket) {

    val basket: Basket

    init{
        this.basket = basket
    }
    fun handle(command: CaptureStuffCommand) {
        basket.saveStuff(command.stuff)
    }
}
