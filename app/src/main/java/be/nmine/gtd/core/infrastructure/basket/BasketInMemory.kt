package be.nmine.gtd.core.infrastructure.basket

import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow

class BasketInMemory : Basket {

    private var stuffs: MutableList<Stuff> = mutableListOf()

    override suspend fun saveStuff(stuff: Stuff) {
        stuffs.add(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return stuffs.filter { listStuff -> listStuff.name == stuff }.first()
    }

    override fun getAll(): Flow<List<Stuff?>> {
        TODO("Not yet implemented")
    }

}