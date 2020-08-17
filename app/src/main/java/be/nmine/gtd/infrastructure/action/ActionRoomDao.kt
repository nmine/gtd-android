package be.nmine.gtd.infrastructure.action

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import be.nmine.gtd.infrastructure.basket.StuffRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface ActionRoomDao {
    @Query("SELECT * FROM actions")
    fun getAll(): Flow<List<ActionRoom>>

    @Insert
    fun insertAll(actionRoom: ActionRoom)

    @Query("DELETE FROM actions WHERE name = :name")
    fun delete(name:String)
}