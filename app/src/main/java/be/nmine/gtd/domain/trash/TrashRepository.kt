package be.nmine.gtd.domain.trash

import be.nmine.gtd.domain.stuff.Stuff

interface TrashRepository {
    fun getStuff(name:String): Stuff
    fun addStuff(stuff: Stuff)
}
