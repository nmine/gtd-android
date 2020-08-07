package be.nmine.gtd.core.application.getAllStuffs

import be.nmine.gtd.StuffDTO
import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import javax.inject.Inject

class GetAllStuffHandler @Inject constructor(val basket: Basket) {

    init {
        basket.saveStuff(Stuff("test de stuff"))
        basket.saveStuff(Stuff("test de stuff2, test de stuff2, ,test de stuff2, "))
    }
    fun handle(): List<StuffDTO> {
        return basket.getAll().map { stuff -> StuffDTO(stuff.name) }
    }

}
