package be.nmine.gtd.infrastructure.basket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketRoomDao {
    @Query("SELECT * FROM stuffs")
    fun getAll(): Flow<List<StuffRoom>>

    @Insert
    suspend fun save(stuffRoom: StuffRoom)

    @Query("DELETE FROM stuffs WHERE name = :name")
    suspend fun delete(name:String)

}