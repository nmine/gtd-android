package be.nmine.gtd.infrastructure.trash

import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.domain.trash.TrashRepository

class TrashRepositoryInmemory: TrashRepository {

    val trash : MutableList<Stuff> = mutableListOf()

    override suspend fun addStuff(stuff: Stuff) {
        trash.add(stuff)
    }
}

