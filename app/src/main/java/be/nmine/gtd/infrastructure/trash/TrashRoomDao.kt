package be.nmine.gtd.infrastructure.trash

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TrashRoomDao {
    @Insert
    suspend fun save(trashRoom: TrashRoom)

}