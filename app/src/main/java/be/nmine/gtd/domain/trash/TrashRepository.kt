package be.nmine.gtd.domain.trash

import be.nmine.gtd.domain.basket.Stuff

interface TrashRepository {
    suspend fun addStuff(stuff: Stuff)
}
