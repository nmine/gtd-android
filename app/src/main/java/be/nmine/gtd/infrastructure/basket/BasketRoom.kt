package be.nmine.gtd.infrastructure.basket

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.basket.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BasketRoom @Inject constructor(private val basketRoomDao: BasketRoomDao) : Basket {

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

}
