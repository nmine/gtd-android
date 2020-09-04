package be.nmine.gtd.infrastructure.basket

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.time.Duration

class BasketInMemory : Basket {
    private var inboxZero:InboxZero = InboxZero(Duration.ZERO)
    private var stuffs: MutableList<Stuff> = mutableListOf()

    override suspend fun saveStuff(stuff: Stuff) {
        stuffs.add(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return stuffs.filter { listStuff -> listStuff.name == stuff }.first()
    }

    override fun getAll(): Flow<List<Stuff?>> {
        return flowOf(stuffs)
    }

    override suspend fun remove(stuff: Stuff) {
        if(stuffs.size == 1)
            updateTimeSinceLastInboxZero()
        stuffs.remove(stuff)
    }

    override suspend fun updateTimeSinceLastInboxZero() {
        inboxZero.update()
    }

    override suspend fun getTimeSinceLastInboxZero(): InboxZero {
        return inboxZero
    }

}
