package be.nmine.gtd.infrastructure.action

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ActionRoomDao {
    @Query("SELECT * FROM actions")
    fun getAll(): Flow<List<ActionRoom>>

    @Insert
    suspend fun save(actionRoom: ActionRoom)

    @Query("DELETE FROM actions WHERE name = :name")
    suspend fun delete(name:String)
}