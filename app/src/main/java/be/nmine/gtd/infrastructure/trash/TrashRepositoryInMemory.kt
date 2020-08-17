package be.nmine.gtd.infrastructure.trash

import be.nmine.gtd.domain.stuff.Stuff
import be.nmine.gtd.domain.trash.TrashRepository

class TrashRepositoryInmemory: TrashRepository {

    val trash : MutableList<Stuff> = mutableListOf()

    override fun getStuff(name: String): Stuff {
        return trash.filter { stuff -> stuff.name == name }.first()
    }

    override fun addStuff(stuff: Stuff) {
        trash.add(stuff)
    }
}

