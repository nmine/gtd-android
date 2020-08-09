package be.nmine.gtd.core.application.getAllStuffs

import be.nmine.gtd.StuffDTO
import be.nmine.gtd.core.domain.basket.Basket
import javax.inject.Inject

class GetAllStuffHandler @Inject constructor(val basket: Basket) {

    fun handle(): List<StuffDTO> {
        return basket.getAll().map { stuff -> StuffDTO(stuff.name) }
    }

}
