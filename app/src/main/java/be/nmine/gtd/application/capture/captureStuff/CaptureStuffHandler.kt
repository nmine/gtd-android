package be.nmine.gtd.application.capture.captureStuff

import be.nmine.gtd.domain.basket.Basket
import javax.inject.Inject

class CaptureStuffHandler @Inject constructor(basket : Basket) {

    val basket: Basket

    init{
        this.basket = basket
    }
    suspend fun handle(command: CaptureStuffCommand) {
        basket.saveStuff(command.stuff)
    }
}
