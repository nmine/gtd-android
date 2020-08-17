package be.nmine.gtd.domain.basket

import be.nmine.gtd.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow

interface Basket {
    suspend fun saveStuff(stuff: Stuff)
    fun getStuff(stuff: String): Stuff
    fun getAll(): Flow<List<Stuff?>>
    fun remove(stuff: Stuff)

}
