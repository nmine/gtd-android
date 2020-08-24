package be.nmine.gtd.infrastructure.basket

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Duration
import java.time.LocalDateTime
import javax.inject.Inject

class BasketRoom @Inject constructor(private val basketRoomDao: BasketRoomDao,
                                     private val inboxZeroRepositoryRoom: InboxZeroRepositoryRoom) : Basket {

    override suspend fun saveStuff(stuff: Stuff) {
        var stuff = StuffRoom(name = stuff.name)
        basketRoomDao.save(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return Stuff("")
    }

    override fun getAll(): Flow<List<Stuff?>> {
        return basketRoomDao.getAll().map { listStuffRoom: List<StuffRoom> ->
            listStuffRoom.map { stuffRoom ->
                stuffRoom.name?.let { Stuff(it) }
            }
        }
    }

    override suspend fun remove(stuff: Stuff) {
        basketRoomDao.delete(stuff.name)
    }

    override suspend fun getTimeSinceLastInboxZero() : InboxZero {
//        inboxZeroRepositoryRoom.save(InboxZeroRoom(timestamp = Instant.now().toEpochMilli(), name = "default"))
//        val inboxZero = inboxZeroRepositoryRoom.getInboxZero("first")
//            .map{inboxZeroRoom ->
//                InboxZero.from(inboxZeroRoom.timestamp!!) }
//            .first()
//        return inboxZero
        return InboxZero(Duration.ofMillis(1000))
    }

    override suspend fun updateTimeSinceLastInboxZero() {
        val inboxZero = inboxZeroRepositoryRoom.getInboxZero("default").first()
        inboxZero.timestamp = LocalDateTime.now().atZone(java.time.ZoneOffset.UTC).toEpochSecond()
        inboxZeroRepositoryRoom.update(inboxZero)
    }

}
