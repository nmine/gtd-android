package be.nmine.gtd.infrastructure.basket

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BasketInMemory : Basket {

    private var stuffs: MutableList<Stuff> = mutableListOf()

    override suspend fun saveStuff(stuff: Stuff) {
        stuffs.add(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return stuffs.filter { listStuff -> listStuff.name == stuff }.first()
    }

    override fun getAll(): Flow<List<Stuff?>> {
        return flowOf(stuffs)
    }

    override fun remove(stuff: Stuff) {
        stuffs.remove(stuff)
    }

}
