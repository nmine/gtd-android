package be.nmine.gtd.infrastructure.basket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InboxZeroRepositoryRoom {
    @Insert
    suspend fun save(inboxZero: InboxZeroRoom)

    @Query("SELECT * FROM inbox_zero WHERE name = :name")
    suspend fun getInboxZero(name: String):List<InboxZeroRoom>

}