package be.nmine.gtd.infrastructure.nextAction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import be.nmine.gtd.domain.nextaction.NextAction
import kotlinx.coroutines.flow.Flow

@Dao
interface NextActionRoomDao {
    @Query("SELECT * FROM nextactions")
    fun getAll(): Flow<List<NextAction>>

    @Insert
    suspend fun save(nextAction: NextActionRoom)

}