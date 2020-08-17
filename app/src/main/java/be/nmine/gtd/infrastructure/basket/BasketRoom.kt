package be.nmine.gtd.infrastructure.basket

import be.nmine.gtd.domain.basket.Basket
import be.nmine.gtd.domain.stuff.Stuff
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BasketRoom @Inject constructor(private val stuffDao: BasketRoomDao) : Basket {


    override suspend fun saveStuff(stuff: Stuff) {
        var stuff = StuffRoom(name = "toto")
        stuffDao.insertAll(stuff)
    }

    override fun getStuff(stuff: String): Stuff {
        return Stuff("")
    }

    override fun getAll(): Flow<List<Stuff?>> {
        return stuffDao.getAll().map { listStuffRoom: List<StuffRoom> ->
            listStuffRoom.map { stuffRoom ->
                stuffRoom.name?.let { Stuff(it) }
            }
        }
    }

    override fun remove(stuff: Stuff) {
        stuffDao.delete(stuff.name)
    }

}
