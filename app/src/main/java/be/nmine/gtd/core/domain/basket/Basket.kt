package be.nmine.gtd.core.domain.basket

import be.nmine.gtd.core.domain.stuff.Stuff

interface Basket {
    fun saveStuff(stuff: Stuff)
    fun getStuff(stuff: String): Stuff

}
