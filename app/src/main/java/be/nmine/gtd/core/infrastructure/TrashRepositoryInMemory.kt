package be.nmine.gtd.core.infrastructure

import be.nmine.gtd.core.domain.stuff.Stuff
import be.nmine.gtd.core.domain.trash.TrashRepository

class TrashRepositoryInmemory: TrashRepository {

    val trash : MutableList<Stuff> = mutableListOf()

    override fun getStuff(name: String): Stuff {
        return trash.filter { stuff -> stuff.name == name }.first()
    }

    override fun addStuff(stuff: Stuff) {
        trash.add(stuff)
    }
}

