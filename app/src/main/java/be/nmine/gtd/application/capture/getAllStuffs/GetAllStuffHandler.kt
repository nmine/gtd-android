package be.nmine.gtd.application.capture.getAllStuffs

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllStuffHandler @Inject constructor(val basket: Basket) {

    fun handle(): Flow<List<Stuff?>> {
        return basket.getAll()
    }

}
