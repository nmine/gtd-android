package be.nmine.gtd.infrastructure.trash

import be.nmine.gtd.domain.basket.Stuff
import be.nmine.gtd.domain.trash.TrashRepository
import javax.inject.Inject

class TrashRepositoryRoom @Inject constructor(private val trashRoomDao: TrashRoomDao) : TrashRepository {

    override suspend fun addStuff(stuff: Stuff) {
        trashRoomDao.save(TrashRoom(name =  stuff.name))
    }


}
