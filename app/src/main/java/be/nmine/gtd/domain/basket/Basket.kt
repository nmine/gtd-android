package be.nmine.gtd.domain.basket

import be.nmine.gtd.infrastructure.basket.InboxZero
import kotlinx.coroutines.flow.Flow

interface Basket {
    suspend fun saveStuff(stuff: Stuff)
    fun getStuff(stuff: String): Stuff
    fun getAll(): Flow<List<Stuff?>>
    suspend fun remove(stuff: Stuff)
    suspend fun getTimeSinceLastInboxZero(): InboxZero
    suspend fun updateTimeSinceLastInboxZero()
}
