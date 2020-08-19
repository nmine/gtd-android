package be.nmine.gtd.domain.basket

import kotlinx.coroutines.flow.Flow

interface Basket {
    suspend fun saveStuff(stuff: Stuff)
    fun getStuff(stuff: String): Stuff
    fun getAll(): Flow<List<Stuff?>>
    suspend fun remove(stuff: Stuff)

}
