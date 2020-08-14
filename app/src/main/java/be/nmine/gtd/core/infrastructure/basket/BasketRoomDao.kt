package be.nmine.gtd.core.infrastructure.basket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketRoomDao {
    @Query("SELECT * FROM stuffs")
    fun getAll(): Flow<List<StuffRoom>>

    @Insert
    suspend fun insertAll(stuffRoom: StuffRoom)

    @Delete
    fun delete(stuffRoom: StuffRoom)
}