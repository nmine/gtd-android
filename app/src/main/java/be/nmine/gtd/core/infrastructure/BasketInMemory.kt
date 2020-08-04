package be.nmine.gtd.core.infrastructure

import be.nmine.gtd.core.domain.Basket
import be.nmine.gtd.core.domain.Stuff

class BasketInMemory : Basket {

    private var stuffs: MutableList<Stuff> = mutableListOf()

    override fun saveStuff(stuff: Stuff) {
        stuffs.add(stuff)
    }

    override fun getStuff(stuff: String):Stuff {
        return stuffs.filter { listStuff -> listStuff.name == stuff }.first()
    }
}
