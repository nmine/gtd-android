package be.nmine.gtd.core.infrastructure

import be.nmine.gtd.core.domain.basket.Basket
import be.nmine.gtd.core.domain.stuff.Stuff
import javax.inject.Inject

class BasketInMemory  @Inject constructor(): Basket {

    private var stuffs: MutableList<Stuff> = mutableListOf()

    override fun saveStuff(stuff: Stuff) {
        stuffs.add(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return stuffs.filter { listStuff -> listStuff.name == stuff }.first()
    }

    override fun getAll(): List<Stuff> {
        return stuffs
    }
}
