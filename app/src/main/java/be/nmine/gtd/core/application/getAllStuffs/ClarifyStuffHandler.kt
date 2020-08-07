package be.nmine.gtd.core.application.getAllStuffs

import be.nmine.gtd.StuffDTO
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff

class GetAllStuffHandler(val basket: Basket) {

    init {
        basket.saveStuff(Stuff("test de stuff"))
    }
    fun handle(): List<StuffDTO> {
        return basket.getAll().map { stuff -> StuffDTO(stuff.name) }
    }

}
