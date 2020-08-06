package be.nmine.gtd.core.domain.trash

import be.nmine.gtd.core.domain.stuff.Stuff

interface TrashRepository {
    fun getStuff(name:String): Stuff
    fun addStuff(stuff: Stuff)
}
