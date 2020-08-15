package be.nmine.gtd.core.application.capture.getAllStuffs

import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllStuffHandler @Inject constructor(val basket: Basket) {

    fun handle(): Flow<List<Stuff?>> {
        return basket.getAll()
    }

}
