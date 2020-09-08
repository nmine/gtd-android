package be.nmine.gtd.infrastructure.nextAction

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nextactions")
data class NextActionRoom(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name") var name: String?
)
